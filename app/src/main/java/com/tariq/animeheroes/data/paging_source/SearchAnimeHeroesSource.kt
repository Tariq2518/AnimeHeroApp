package com.tariq.animeheroes.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tariq.animeheroes.data.remote.AnimeHeroApi
import com.tariq.animeheroes.domain.model.AnimeHero
import javax.inject.Inject

class SearchAnimeHeroesSource @Inject constructor(
    private val animeHeroApi: AnimeHeroApi,
    private val query: String
) : PagingSource<Int, AnimeHero>() {
    override fun getRefreshKey(state: PagingState<Int, AnimeHero>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeHero> {
        return try {
            val apiResult = animeHeroApi.searchAnimeHeroes(name = query)
            val animeHeroes = apiResult.animeHeroes
            if (animeHeroes.isNotEmpty()) {
                LoadResult.Page(
                    data = animeHeroes,
                    prevKey = apiResult.previousPage,
                    nextKey = apiResult.nextPage,
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}