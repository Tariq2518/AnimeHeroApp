package com.tariq.animeheroes.data.paging_source

import androidx.paging.*
import androidx.paging.RemoteMediator.*
import androidx.test.core.app.ApplicationProvider
import com.tariq.animeheroes.data.local.AnimeHeroDatabase
import com.tariq.animeheroes.data.remote.FakeAnimeHeroApi2
import com.tariq.animeheroes.domain.model.AnimeHero
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class HeroRemoteMediatorTest {

    private lateinit var animeHeroApi: FakeAnimeHeroApi2
    private lateinit var animeHeroDatabase: AnimeHeroDatabase

    @Before
    fun setup() {
        animeHeroApi = FakeAnimeHeroApi2()
        animeHeroDatabase = AnimeHeroDatabase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @After
    fun cleanup() {
        animeHeroDatabase.clearAllTables()
    }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadReturnsSuccessResultWhenMoreDataIsPresent() =
        runBlocking {
            val remoteMediator = AnimeHeroRemoteMediator(
                animeHeroApi = animeHeroApi,
                animeHeroDatabase = animeHeroDatabase
            )
            val pagingState = PagingState<Int, AnimeHero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Success)
            assertFalse((result as MediatorResult.Success).endOfPaginationReached)
        }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadSuccessAndEndOfPaginationTrueWhenNoMoreData() =
        runBlocking {
            animeHeroApi.clearData()
            val remoteMediator = AnimeHeroRemoteMediator(
                animeHeroApi = animeHeroApi,
                animeHeroDatabase = animeHeroDatabase
            )
            val pagingState = PagingState<Int, AnimeHero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Success)
            assertTrue((result as MediatorResult.Success).endOfPaginationReached)
        }

    @ExperimentalPagingApi
    @Test
    fun refreshLoadReturnsErrorResultWhenErrorOccurs() =
        runBlocking {
            animeHeroApi.addException()
            val remoteMediator = AnimeHeroRemoteMediator(
                animeHeroApi = animeHeroApi,
                animeHeroDatabase = animeHeroDatabase
            )
            val pagingState = PagingState<Int, AnimeHero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(LoadType.REFRESH, pagingState)
            assertTrue(result is MediatorResult.Error)
        }

}