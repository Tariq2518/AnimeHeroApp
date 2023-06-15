package com.tariq.animeheroes.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.RemoteMediator
import com.tariq.animeheroes.data.local.AnimeHeroDatabase
import com.tariq.animeheroes.data.paging_source.AnimeHeroRemoteMediator
import com.tariq.animeheroes.data.paging_source.SearchAnimeHeroesSource
import com.tariq.animeheroes.data.remote.AnimeHeroApi
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow


@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val animeHeroApi: AnimeHeroApi,
    private val animeHeroDatabase: AnimeHeroDatabase
) : RemoteDataSource {

    private val animeHeroDao = animeHeroDatabase.animeHeroDao()


    override fun getAllAnimeHeroes(): Flow<PagingData<AnimeHero>> {
        val pagingSourceFactory = { animeHeroDao.getAllAnimeHeroes() }
        return Pager(
            config = PagingConfig(pageSize = 3),
            remoteMediator = AnimeHeroRemoteMediator(
                animeHeroApi = animeHeroApi,
                animeHeroDatabase = animeHeroDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchAnimeHeroes(query: String): Flow<PagingData<AnimeHero>> {
        return Pager(
            config = PagingConfig(pageSize = 3),
            pagingSourceFactory = {
                SearchAnimeHeroesSource(animeHeroApi = animeHeroApi, query = query)
            }
        ).flow
    }
}