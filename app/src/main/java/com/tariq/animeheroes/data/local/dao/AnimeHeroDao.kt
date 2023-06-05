package com.tariq.animeheroes.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tariq.animeheroes.domain.model.AnimeHero

@Dao
interface AnimeHeroDao {

    @Query("SELECT * FROM anime_hero_table ORDER BY id ASC")
    fun getAllAnimeHeroes(): PagingSource<Int, AnimeHero>

    @Query("SELECT * FROM anime_hero_table WHERE id=:animeHeroId")
    fun getSelectedAnimeHero(animeHeroId: Int): AnimeHero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllAnimeHeroes(animeHeroes: List<AnimeHero>)

    @Query("DELETE FROM anime_hero_table")
    suspend fun deleteAllAnimeHeroes()

}