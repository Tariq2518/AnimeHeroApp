package com.tariq.animeheroes.domain.use_cases.get_selected_hero

import com.tariq.animeheroes.data.repository.Repository
import com.tariq.animeheroes.domain.model.AnimeHero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(animeHeroId: Int): AnimeHero {
        return repository.getSelectedAnimHero(animeHeroId = animeHeroId)
    }

}