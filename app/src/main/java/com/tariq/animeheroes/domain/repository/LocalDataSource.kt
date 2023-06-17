package com.tariq.animeheroes.domain.repository

import com.tariq.animeheroes.domain.model.AnimeHero

interface LocalDataSource {
    suspend fun getSelectedAnimeHero(animeHeroId: Int): AnimeHero
}