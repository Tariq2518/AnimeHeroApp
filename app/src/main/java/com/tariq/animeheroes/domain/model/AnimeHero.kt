package com.tariq.animeheroes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tariq.animeheroes.utils.Constants.ANIME_HERO_TABLE

@Entity(tableName = ANIME_HERO_TABLE)
data class AnimeHero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name:String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
)
