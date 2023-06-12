package com.tariq.animeheroes.di

import androidx.paging.ExperimentalPagingApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tariq.animeheroes.data.local.AnimeHeroDatabase
import com.tariq.animeheroes.data.remote.AnimeHeroApi
import com.tariq.animeheroes.data.repository.RemoteDataSourceImpl
import com.tariq.animeheroes.domain.repository.RemoteDataSource
import com.tariq.animeheroes.utils.Constants.LOCAL_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder()
            .baseUrl(LOCAL_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()

    }

    @Provides
    @Singleton
    fun provideAnimeHeroApi(retrofit: Retrofit): AnimeHeroApi {
        return retrofit.create(AnimeHeroApi::class.java)
    }


    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun providesRemoteDataSource(
        animeHeroApi: AnimeHeroApi,
        animeHeroDatabase: AnimeHeroDatabase
    ): RemoteDataSource {
        return RemoteDataSourceImpl(
            animeHeroApi = animeHeroApi,
            animeHeroDatabase = animeHeroDatabase
        )
    }

}