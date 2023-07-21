package com.tariq.animeheroes.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tariq.animeheroes.data.local.dao.AnimeHeroDao
import com.tariq.animeheroes.data.local.dao.AnimeHeroRemoteKeyDao
import com.tariq.animeheroes.domain.model.AnimeHero
import com.tariq.animeheroes.domain.model.AnimeHeroRemoteKey

@Database(entities = [AnimeHero::class, AnimeHeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class AnimeHeroDatabase: RoomDatabase() {

    companion object {
        fun create(context: Context, useInMemory: Boolean): AnimeHeroDatabase {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, AnimeHeroDatabase::class.java)
            } else {
                Room.databaseBuilder(context, AnimeHeroDatabase::class.java, "test_database.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    abstract fun animeHeroDao(): AnimeHeroDao

    abstract fun heroRemoteKeyDao(): AnimeHeroRemoteKeyDao

}