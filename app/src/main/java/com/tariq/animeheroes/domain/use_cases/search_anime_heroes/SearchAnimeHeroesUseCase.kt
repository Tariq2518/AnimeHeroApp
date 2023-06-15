package com.tariq.animeheroes.domain.use_cases.search_anime_heroes

import android.app.DownloadManager.Query
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.tariq.animeheroes.data.repository.Repository
import com.tariq.animeheroes.domain.model.AnimeHero
import kotlinx.coroutines.flow.Flow

class SearchAnimeHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<AnimeHero>> {
        return repository.searchAnimeHeroes(query = query)
    }
}