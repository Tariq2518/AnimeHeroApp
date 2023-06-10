package com.tariq.animeheroes.data.remote

import com.tariq.animeheroes.domain.model.AnimeApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeHeroApi {

    @GET("/anime/heroes")
    suspend fun getAllAnimeHeroes(@Query("page") page: Int = 1): AnimeApiResponse

    @GET("/anime/heroes/search")
    suspend fun searchAnimeHeroes(@Query("name") name: String): AnimeApiResponse

}