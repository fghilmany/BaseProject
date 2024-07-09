package com.fghilmany.baseproject.factories.di

import com.fghilmany.core.ktor.ktorHttpClient
import com.fghilmany.moviedetail.api.DetailMovieHttpClient
import com.fghilmany.moviedetail.apiinfra.DetailMovieRetrofitClient
import com.fghilmany.moviedetail.apiinfra.DetailMovieService
import com.fghilmany.movielist.api.MoviesHttpClient
import com.fghilmany.movielist.apiinfra.MovieService
import com.fghilmany.movielist.apiinfra.MoviesRetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    fun provideDetailMovieService(retrofit: Retrofit): DetailMovieService {
        return retrofit.create(DetailMovieService::class.java)
    }

   /* @Provides
    fun provideMoviesHttpClient(service: MovieService): MoviesHttpClient {
        return MoviesRetrofitClient(service)
    }*/

    @Provides
    fun provideDetailMovieHttpClient(service: DetailMovieService): DetailMovieHttpClient {
        return DetailMovieRetrofitClient(service)
    }

    @Provides
    fun provideKtorMovieService(): HttpClient {
        return ktorHttpClient
    }

    @Provides
    fun provideMoviesHttpClient(ktorHttpClient: HttpClient): MoviesHttpClient {
        return MoviesRetrofitClient(ktorHttpClient)
    }
}