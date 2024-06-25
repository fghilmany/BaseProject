package com.fghilmany.baseproject.factories.di

import com.fghilmany.moviedetail.domain.LoadDetailMovie
import com.fghilmany.moviedetail.presentation.DetailMovieViewModel
import dagger.Binds
import dagger.Module
import dagger.assisted.AssistedFactory
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule{
    @Binds
    @ViewModelScoped
    abstract fun provideLoadDetailMovie(
        @CompositeAnnotation loadDetailMovie: LoadDetailMovie
    ): LoadDetailMovie

}
