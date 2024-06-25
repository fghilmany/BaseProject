package com.fghilmany.baseproject.factories.di

import com.fghilmany.core.sqlite.AppDatabase
import com.fghilmany.moviedetail.cache.DetailMovieLocalClient
import com.fghilmany.moviedetail.cacheinfra.DetailMovieDao
import com.fghilmany.moviedetail.cacheinfra.DetailMovieRoomClient
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
