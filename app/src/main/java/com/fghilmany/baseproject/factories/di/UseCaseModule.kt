package com.fghilmany.baseproject.factories.di

import com.fghilmany.baseproject.feature.moviedetail.api.DetailMovieHttpClient
import com.fghilmany.baseproject.feature.moviedetail.api.LoadDetailMovieUseCase
import com.fghilmany.baseproject.feature.moviedetail.cache.DetailMovieLocalClient
import com.fghilmany.baseproject.feature.moviedetail.cache.InsertDetailMovieUseCase
import com.fghilmany.baseproject.feature.moviedetail.domain.InsertDetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.LoadDetailMovie
import com.fghilmany.baseproject.feature.movielist.api.LoadMoviesUseCase
import com.fghilmany.baseproject.feature.movielist.api.MoviesHttpClient
import com.fghilmany.baseproject.feature.movielist.domain.LoadMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideLoadMoviesUseCase(client: MoviesHttpClient): LoadMovies {
        return LoadMoviesUseCase(client)
    }

    @BaseLoadDetailMovie
    @Provides
    fun provideLoadDetailMovieUseCase(
        client: DetailMovieHttpClient
    ): LoadDetailMovie {
        return LoadDetailMovieUseCase(client)
    }

    @BaseInsertDetailMovie
    @Provides
    fun provideInsertDetailMovieUseCase(client: DetailMovieLocalClient): InsertDetailMovie {
        return InsertDetailMovieUseCase(client)
    }
}