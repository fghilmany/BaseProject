package com.fghilmany.baseproject.factories.di

import com.fghilmany.baseproject.feature.moviedetail.decorator.DetailMovieDecorator
import com.fghilmany.baseproject.feature.moviedetail.domain.InsertDetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.LoadDetailMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DecoratorModule{
    @Provides
    fun provideDetailMovieDecorator(
        @BaseLoadDetailMovie loadDetailMovie: LoadDetailMovie,
        @BaseInsertDetailMovie insertDetailMovie: InsertDetailMovie
    ): DetailMovieDecorator {
        return DetailMovieDecorator(loadDetailMovie, insertDetailMovie)
    }
}