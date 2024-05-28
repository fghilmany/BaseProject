package com.fghilmany.baseproject.factories.di

import com.fghilmany.baseproject.feature.moviedetail.decorator.DetailMovieDecorator
import com.fghilmany.baseproject.feature.moviedetail.domain.LoadDetailMovie
import com.fghilmany.baseproject.feature.moviedetail.presentation.DetailMovieViewModel
import dagger.Module
import dagger.Provides
import dagger.assisted.AssistedFactory
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule{
    @Provides
    @ViewModelScoped
    fun provideLoadDetailMovie(
        detailMovieDecorator: DetailMovieDecorator
    ): LoadDetailMovie {
        return detailMovieDecorator
    }

}

@AssistedFactory
interface ViewModelFactory {
    fun createDetailMovieViewModel(movieId: Int): DetailMovieViewModel
}