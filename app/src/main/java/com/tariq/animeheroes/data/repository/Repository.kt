package com.tariq.animeheroes.data.repository

import androidx.paging.PagingData
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.domain.repository.DataStoreOperations
import com.tariq.animeheroes.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllAnimeHeroes(): Flow<PagingData<AnimeHero>> {
        return remote.getAllAnimeHeroes()
    }

    suspend fun saveOnBoardingState(onCompleted: Boolean) {
        dataStore.saveOnBoardingState(onComplete = onCompleted)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }


}