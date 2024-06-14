package com.fghilmany.baseproject.factories.di

import com.fghilmany.moviedetail.api.DetailMovieHttpClient
import com.fghilmany.moviedetail.api.GetRemoteDetailMovieUseCase
import com.fghilmany.moviedetail.cache.DetailMovieLocalClient
import com.fghilmany.moviedetail.cache.GetLocalMovieDetailsUseCase
import com.fghilmany.moviedetail.cache.InsertDetailMovieUseCase
import com.fghilmany.moviedetail.domain.InsertDetailMovie
import com.fghilmany.moviedetail.domain.LoadDetailMovie
import com.fghilmany.movielist.api.LoadMoviesUseCase
import com.fghilmany.movielist.api.MoviesHttpClient
import com.fghilmany.movielist.domain.LoadMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteUseCaseModule {

    @Provides
    fun provideLoadMoviesUseCase(client: MoviesHttpClient): LoadMovies {
        return LoadMoviesUseCase(client)
    }

    @RemoteUseCaseAnnotation
    @Provides
    fun provideLoadDetailMovieUseCase(
        client: DetailMovieHttpClient
    ): LoadDetailMovie {
        return GetRemoteDetailMovieUseCase(client)
    }

}
@Module
@InstallIn(SingletonComponent::class)
object LocalUseCaseModule {

    @LocalUseCaseAnnotation
    @Provides
    fun provideInsertDetailMovieUseCase(client: DetailMovieLocalClient): InsertDetailMovie {
        return InsertDetailMovieUseCase(client)
    }

    @LocalUseCaseAnnotation
    @Provides
    fun provideLoadDetailMovieUseCase(
        client: DetailMovieLocalClient
    ): LoadDetailMovie {
        return GetLocalMovieDetailsUseCase(client)
    }
}