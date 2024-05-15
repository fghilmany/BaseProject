package com.fghilmany.baseproject.factories

import com.fghilmany.baseproject.core.network.rest.RetrofitFactory
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
import com.fghilmany.baseproject.feature.movielist.presentation.MoviesViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
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
abstract class RemoteMovieLoaderFactory {
    @Binds
    abstract fun createRemoteMovieLoader(
        remoteMovieLoader: LoadMoviesUseCase
    ): LoadMovies

    @Binds
    abstract fun createRemoteDetailMovieLoader(
        remoteDetailMovieLoader: LoadDetailMovieUseCase
    ): LoadDetailMovie
}
@Component(
    modules = [
        RemoteMovieLoaderFactory::class,
        MovieHttpClientFactory::class,
        ListMovieServiceFactory::class,
        RetrofitFactory::class
    ]
)
@Singleton
interface MainComponent {
    @Component.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun listMovieViewModel(): MoviesViewModel
    fun detailMovieViewModel(): DetailMovieViewModel
}