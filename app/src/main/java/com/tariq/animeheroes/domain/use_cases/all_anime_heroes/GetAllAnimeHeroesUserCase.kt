package com.tariq.animeheroes.domain.use_cases.all_anime_heroes

import androidx.paging.PagingData
import com.tariq.animeheroes.data.repository.Repository
import com.tariq.animeheroes.domain.model.AnimeHero
import kotlinx.coroutines.flow.Flow

class GetAllAnimeHeroesUserCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<AnimeHero>> {
        return repository.getAllAnimeHeroes()
    }

}