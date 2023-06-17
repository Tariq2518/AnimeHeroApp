package com.tariq.animeheroes.data.repository

import androidx.paging.PagingData
import com.tariq.animeheroes.data.local.AnimeHeroDatabase
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.domain.repository.DataStoreOperations
import com.tariq.animeheroes.domain.repository.LocalDataSource
import com.tariq.animeheroes.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllAnimeHeroes(): Flow<PagingData<AnimeHero>> {
        return remote.getAllAnimeHeroes()
    }

    suspend fun getSelectedAnimHero(animeHeroId: Int): AnimeHero{
        return local.getSelectedAnimeHero(animeHeroId = animeHeroId)
    }

    fun searchAnimeHeroes(query: String): Flow<PagingData<AnimeHero>> {
        return remote.searchAnimeHeroes(query = query)
    }

    suspend fun saveOnBoardingState(onCompleted: Boolean) {
        dataStore.saveOnBoardingState(onComplete = onCompleted)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }


}