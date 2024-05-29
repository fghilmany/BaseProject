package com.fghilmany.baseproject.factories.di

import com.fghilmany.baseproject.feature.moviedetail.composite.DetailMovieComposite
import com.fghilmany.baseproject.feature.moviedetail.domain.LoadDetailMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object CompositeModule {
    @CompositeAnnotation
    @Provides
    @ViewModelScoped
    fun providesCompositeModule(
        @LocalUseCaseAnnotation primary: LoadDetailMovie,
        @DecoratorAnnotation fallback: LoadDetailMovie
    ): LoadDetailMovie{
        return DetailMovieComposite(primary, fallback)
    }
}