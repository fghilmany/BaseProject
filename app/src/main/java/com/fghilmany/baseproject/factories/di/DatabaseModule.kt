package com.fghilmany.baseproject.factories.di

import com.fghilmany.baseproject.core.db.sqlite.AppDatabase
import com.fghilmany.baseproject.feature.moviedetail.cache.DetailMovieLocalClient
import com.fghilmany.baseproject.feature.moviedetail.cacheinfra.DetailMovieDao
import com.fghilmany.baseproject.feature.moviedetail.cacheinfra.DetailMovieRoomClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDetailMovieDao(database: AppDatabase): DetailMovieDao {
        return database.detailMovieDao()
    }

    @Provides
    fun provideDetailMovieLocalClient(dao: DetailMovieDao): DetailMovieLocalClient {
        return DetailMovieRoomClient(dao)
    }
}
