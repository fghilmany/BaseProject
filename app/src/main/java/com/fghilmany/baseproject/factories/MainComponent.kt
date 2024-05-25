package com.fghilmany.baseproject.factories

import com.fghilmany.baseproject.core.db.sqlite.AppDatabase
import com.fghilmany.baseproject.feature.moviedetail.api.DetailMovieHttpClient
import com.fghilmany.baseproject.feature.moviedetail.api.LoadDetailMovieUseCase
import com.fghilmany.baseproject.feature.moviedetail.apiinfra.DetailMovieRetrofitClient
import com.fghilmany.baseproject.feature.moviedetail.apiinfra.DetailMovieService
import com.fghilmany.baseproject.feature.moviedetail.cache.DetailMovieLocalClient
import com.fghilmany.baseproject.feature.moviedetail.cache.InsertDetailMovieUseCase
import com.fghilmany.baseproject.feature.moviedetail.cacheinfra.DetailMovieDao
import com.fghilmany.baseproject.feature.moviedetail.cacheinfra.DetailMovieRoomClient
import com.fghilmany.baseproject.feature.moviedetail.decorator.DetailMovieDecorator
import com.fghilmany.baseproject.feature.moviedetail.domain.InsertDetailMovie
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
import javax.inject.Singleton

/*
@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {
    @Provides
    fun createListMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    fun createDetailMovieService(retrofit: Retrofit): DetailMovieService {
        return retrofit.create(DetailMovieService::class.java)
    }

    @Provides
    fun createDetailMovieDao(database: AppDatabase): DetailMovieDao = database.detailMovieDao()
}
@Module
@InstallIn(SingletonComponent::class)
abstract class BusinessModule {
    @Binds
    abstract fun createMovieHttpClient(
        listMovieRetrofitHttpClient: MoviesRetrofitClient
    ): MoviesHttpClient

    @Binds
    abstract fun createDetailMovieHttpClient(
        detailMovieRetrofitHttpClient: DetailMovieRetrofitClient
    ): DetailMovieHttpClient
    @Binds
    abstract fun createDetailMovieLocalClient(
        detailMovieRoomClient: DetailMovieRoomClient
    ): DetailMovieLocalClient
}

*/
/*@Module
@InstallIn(SingletonComponent::class)
abstract class DecoratorModule {
    @Binds
    abstract fun createDetailMovieDecorator(
        decorator: LoadDetailMovie,
        local: InsertDetailMovie,
    ): LoadMovies
}*//*

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun createRemoteMovieLoader(
        remoteMovieLoader: LoadMoviesUseCase
    ): LoadMovies

    @Binds
    abstract fun createRemoteDetailMovieLoader(
        remoteDetailMovieLoader: LoadDetailMovieUseCase
    ): LoadDetailMovie
    @Binds
    abstract fun createLocalDetailMovieInsert(
        localDetailMovieUseCase: InsertDetailMovieUseCase
    ): InsertDetailMovie

}

@AssistedFactory
interface MovieViewModelFactory {
    fun create(movieId: Int): DetailMovieViewModel
}

*/
/*@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideRemoteCryptoFeedLoader(
        cryptoFeedHttpClient: DetailMovieHttpClient
    ): LoadDetailMovie {
        return LoadDetailMovieUseCase(cryptoFeedHttpClient)
    }

    @Provides
    @Singleton
    fun provideLocalCryptoFeedLoader(
        cryptoFeedDao: DetailMovieLocalClient
    ): InsertDetailMovie {
        return InsertDetailMovieUseCase(cryptoFeedDao)
    }
}*//*

@Module
@InstallIn(SingletonComponent::class)
object DecoratorModule{


    @Provides
    @Singleton
    fun provideDetailMovieDecorator(
        decorator: LoadDetailMovie,
        local: InsertDetailMovie
    ): LoadDetailMovie =
        DetailMovieDecorator(
            decorator, local
        )

}
*/
/*
@Module
@InstallIn(SingletonComponent::class)
object DecoratorVMModule{

    @Provides
    @Singleton
    fun provideCryptoFeedDecorator(
        remoteLoader: LoadDetailMovie,
        localLoader: InsertDetailMovie
    ): LoadDetailMovie {
        return DetailMovieDecorator(remoteLoader, localLoader)
    }
}*//*

*/

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    @Singleton
    fun provideDetailMovieService(retrofit: Retrofit): DetailMovieService {
        return retrofit.create(DetailMovieService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesHttpClient(service: MovieService): MoviesHttpClient {
        return MoviesRetrofitClient(service)
    }

    @Provides
    @Singleton
    fun provideDetailMovieHttpClient(service: DetailMovieService): DetailMovieHttpClient {
        return DetailMovieRetrofitClient(service)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDetailMovieDao(database: AppDatabase): DetailMovieDao {
        return database.detailMovieDao()
    }

    @Provides
    @Singleton
    fun provideDetailMovieLocalClient(dao: DetailMovieDao): DetailMovieLocalClient {
        return DetailMovieRoomClient(dao)
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideLoadMoviesUseCase(client: MoviesHttpClient): LoadMovies {
        return LoadMoviesUseCase(client)
    }

    @Provides
    @ViewModelScoped
    fun provideLoadDetailMovieUseCase(client: DetailMovieHttpClient): LoadDetailMovie {
        return LoadDetailMovieUseCase(client)
    }

    @Provides
    @ViewModelScoped
    fun provideInsertDetailMovieUseCase(client: DetailMovieLocalClient): InsertDetailMovie {
        return InsertDetailMovieUseCase(client)
    }
}

/*
@Module
@InstallIn(ViewModelComponent::class)
object DecoratorModule {

    @Provides
    @ViewModelScoped
    fun provideDetailMovieDecorator(
        loadDetailMovie: LoadDetailMovie,
        insertDetailMovie: InsertDetailMovie
    ): LoadDetailMovie {
        return DetailMovieDecorator(loadDetailMovie, insertDetailMovie)
    }
}
*/


@AssistedFactory
interface ViewModelFactory {
    fun createDetailMovieViewModel(movieId: Int): DetailMovieViewModel
}