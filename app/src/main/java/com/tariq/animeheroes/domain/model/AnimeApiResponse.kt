package com.tariq.animeheroes.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AnimeApiResponse(
    val success: Boolean,
    val message: String? = null,
    val previousPage: Int? = null,
    val nextPage: Int? = null,
    val animeHeroes: List<AnimeHero> = emptyList(),
    val lastUpdated: Long? = null
)