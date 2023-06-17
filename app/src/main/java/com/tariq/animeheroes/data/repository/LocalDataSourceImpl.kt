package com.tariq.animeheroes.data.repository

import com.tariq.animeheroes.data.local.AnimeHeroDatabase
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    animeHeroDatabase: AnimeHeroDatabase
) : LocalDataSource {

    private val animeHeroDao = animeHeroDatabase.animeHeroDao()

    override suspend fun getSelectedAnimeHero(animeHeroId: Int): AnimeHero {
        return animeHeroDao.getSelectedAnimeHero(animeHeroId = animeHeroId)
    }
}