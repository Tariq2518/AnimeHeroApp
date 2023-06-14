package com.tariq.animeheroes.data.paging_source

import androidx.compose.runtime.currentRecomposeScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.tariq.animeheroes.data.local.AnimeHeroDatabase
import com.tariq.animeheroes.data.remote.AnimeHeroApi
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.domain.model.AnimeHeroRemoteKey

@OptIn(ExperimentalPagingApi::class)
class AnimeHeroRemoteMediator(
    private val animeHeroApi: AnimeHeroApi,
    private val animeHeroDatabase: AnimeHeroDatabase
) : RemoteMediator<Int, AnimeHero>() {

    private val animeHeroDao = animeHeroDatabase.animeHeroDao()
    private val animeHeroRemoteKeysDao = animeHeroDatabase.heroRemoteKeyDao()

    private suspend fun getRemoteKeysClosestToCurrentPosition(
        state: PagingState<Int, AnimeHero>
    ): AnimeHeroRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                animeHeroRemoteKeysDao.getRemoteKey(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, AnimeHero>
    ): AnimeHeroRemoteKey? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { animeHero ->
                animeHeroRemoteKeysDao.getRemoteKey(id = animeHero.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, AnimeHero>
    ): AnimeHeroRemoteKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { animeHero ->
                animeHeroRemoteKeysDao.getRemoteKey(id = animeHero.id)
            }
    }

    override suspend fun initialize(): InitializeAction {
        val currentTime = System.currentTimeMillis()
        val lastUpdatedTime = animeHeroRemoteKeysDao.getRemoteKey(id = 1)?.lastUpdated ?: 0L
        val cacheTimeOut = 5
        val differenceInMinutes = (currentTime - lastUpdatedTime) / 1000 / 60
        return if (differenceInMinutes.toInt() <= cacheTimeOut) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, AnimeHero>): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeysClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val previousPage = remoteKeys?.previousPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    previousPage
                }

                LoadType.APPEND -> {
                    val remoteKey = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKey?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKey != null
                        )
                    nextPage
                }
            }
            val response = animeHeroApi.getAllAnimeHeroes(page = page)
            if (response.animeHeroes.isNotEmpty()) {
                animeHeroDatabase.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        animeHeroDao.deleteAllAnimeHeroes()
                        animeHeroRemoteKeysDao.deleteAllRemoteKeys()
                    }
                    val previousPage = response.previousPage
                    val nextPage = response.nextPage
                    val keys = response.animeHeroes.map { animeHero ->
                        AnimeHeroRemoteKey(
                            id = animeHero.id,
                            previousPage = previousPage,
                            nextPage = nextPage,
                            lastUpdated = response.lastUpdated
                        )
                    }
                    animeHeroRemoteKeysDao.addAllRemoteKeys(animeHeroRemoteKeys = keys)
                    animeHeroDao.addAllAnimeHeroes(animeHeroes = response.animeHeroes)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}