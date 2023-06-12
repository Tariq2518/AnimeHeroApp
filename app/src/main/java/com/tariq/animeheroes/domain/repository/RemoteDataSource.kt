package com.tariq.animeheroes.domain.repository

import androidx.paging.PagingData
import com.tariq.animeheroes.domain.model.AnimeHero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllAnimeHeroes(): Flow<PagingData<AnimeHero>>
    fun searchAnimeHeroes(): Flow<PagingData<AnimeHero>>
}