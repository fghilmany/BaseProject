package com.fghilmany.baseproject.factories.di

import com.fghilmany.baseproject.feature.moviedetail.decorator.DetailMovieDecorator
import com.fghilmany.baseproject.feature.moviedetail.domain.InsertDetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.LoadDetailMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DecoratorModule{

    @DecoratorAnnotation
    @Provides
    @Singleton
    fun provideDetailMovieDecorator(
        @RemoteUseCaseAnnotation loadDetailMovie: LoadDetailMovie,
        @LocalUseCaseAnnotation insertDetailMovie: InsertDetailMovie
    ): LoadDetailMovie {
        return DetailMovieDecorator(loadDetailMovie, insertDetailMovie)
    }

}