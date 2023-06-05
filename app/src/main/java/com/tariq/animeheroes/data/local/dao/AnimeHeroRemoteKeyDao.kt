package com.tariq.animeheroes.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tariq.animeheroes.domain.model.AnimeHeroRemoteKey

@Dao
interface AnimeHeroRemoteKeyDao {

    @Query("SELECT * FROM anime_hero_remote_key_table WHERE id=:id")
    suspend fun getRemoteKey(id: Int): AnimeHeroRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(animeHeroRemoteKeys: List<AnimeHeroRemoteKey>)

    @Query("DELETE FROM anime_hero_remote_key_table")
    suspend fun deleteAllRemoteKeys()

}