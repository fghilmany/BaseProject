package com.fghilmany.baseproject.factories

import com.fghilmany.baseproject.feature.moviedetail.api.DetailMovieHttpClient
import com.fghilmany.baseproject.feature.moviedetail.api.LoadDetailMovieUseCase
import com.fghilmany.baseproject.feature.moviedetail.apiinfra.DetailMovieRetrofitClient
import com.fghilmany.baseproject.feature.moviedetail.apiinfra.DetailMovieService
import com.fghilmany.baseproject.feature.moviedetail.domain.LoadDetailMovie
import com.fghilmany.baseproject.feature.moviedetail.presentation.DetailMovieViewModel
import com.fghilmany.baseproject.feature.movielist.api.LoadMoviesUseCase
import com.fghilmany.baseproject.feature.movielist.api.MoviesHttpClient
import com.fghilmany.baseproject.feature.movielist.apiinfra.MovieService
import com.fghilmany.baseproject.feature.movielist.apiinfra.MoviesRetrofitClient
import com.fghilmany.baseproject.feature.movielist.domain.LoadMovies
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.assisted.AssistedFactory
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ListMovieServiceFactory {
    @Provides
    fun createListMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    fun createDetailMovieService(retrofit: Retrofit): DetailMovieService {
        return retrofit.create(DetailMovieService::class.java)
    }
}
@Module
@InstallIn(SingletonComponent::class)
abstract class MovieHttpClientFactory {
    @Binds
    abstract fun createMovieHttpClient(
        listMovieRetrofitHttpClient: MoviesRetrofitClient
    ): MoviesHttpClient

    @Binds
    abstract fun createDetailMovieHttpClient(
        detailMovieRetrofitHttpClient: DetailMovieRetrofitClient
    ): DetailMovieHttpClient
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteMovieLoaderFactory {
    @Binds
    @ViewModelScoped
    abstract fun createRemoteMovieLoader(
        remoteMovieLoader: LoadMoviesUseCase
    ): LoadMovies

    @Binds
    @ViewModelScoped
    abstract fun createRemoteDetailMovieLoader(
        remoteDetailMovieLoader: LoadDetailMovieUseCase
    ): LoadDetailMovie
}

@AssistedFactory
interface ViewModelFactory {
    fun createDetailMovieViewModel(movieId: Int): DetailMovieViewModel
}