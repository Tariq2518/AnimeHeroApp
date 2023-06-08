package com.tariq.animeheroes.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveOnBoardingState(onComplete: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}