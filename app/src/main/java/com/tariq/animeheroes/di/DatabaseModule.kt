package com.tariq.animeheroes.di

import android.content.Context
import androidx.room.Room
import com.tariq.animeheroes.data.local.AnimeHeroDatabase
import com.tariq.animeheroes.data.repository.LocalDataSourceImpl
import com.tariq.animeheroes.domain.repository.LocalDataSource
import com.tariq.animeheroes.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AnimeHeroDatabase::class.java,
        DATABASE_NAME
    ).build()


    @Provides
    @Singleton
    fun provideLocalDataSource(
        data: AnimeHeroDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(
            animeHeroDatabase = data
        )
    }
}
