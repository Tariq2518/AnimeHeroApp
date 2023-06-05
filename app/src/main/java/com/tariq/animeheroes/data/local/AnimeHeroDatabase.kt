package com.tariq.animeheroes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tariq.animeheroes.data.local.dao.AnimeHeroDao
import com.tariq.animeheroes.data.local.dao.AnimeHeroRemoteKeyDao
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.domain.model.AnimeHeroRemoteKey

@Database(entities = [AnimeHero::class, AnimeHeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class AnimeHeroDatabase: RoomDatabase() {

    abstract fun animeHeroDao(): AnimeHeroDao

    abstract fun heroRemoteKeyDao(): AnimeHeroRemoteKeyDao

}