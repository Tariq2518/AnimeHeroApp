package com.tariq.animeheroes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tariq.animeheroes.utils.Constants.ANIME_HERO_REMOTE_KEY_TABLE

@Entity(tableName = ANIME_HERO_REMOTE_KEY_TABLE)
data class AnimeHeroRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val previousPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?

)
