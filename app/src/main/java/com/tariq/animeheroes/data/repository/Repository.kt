package com.tariq.animeheroes.data.repository

import com.tariq.animeheroes.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations
) {

    suspend fun saveOnBoardingState(onCompleted: Boolean) {
        dataStore.saveOnBoardingState(onComplete = onCompleted)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }


}