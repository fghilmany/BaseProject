package com.fghilmany.moviedetail.cacheinfra

import com.fghilmany.common.*
import com.fghilmany.common.exception.InvalidDataException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailMovieRoomClient @Inject constructor(
    private val movieDao: DetailMovieDao
): com.fghilmany.moviedetail.cache.DetailMovieLocalClient {
    override suspend fun saveDetailMovie(detailMovie: com.fghilmany.moviedetail.cache.LocalDetailMovie) {
        movieDao.insertDetailMovie(detailMovie.toDao())
        movieDao.insertGenre(detailMovie.genres.map { genre -> genre.toDao() })
    }

    override suspend fun getDetailById(movieId: Int): Flow<ResultData<com.fghilmany.moviedetail.cache.LocalDetailMovie>> {
        return flow {
            try {
                val detailMovie = movieDao.getDetailMovieById(movieId).toAppLogic()
                emit(ResultData.Success(detailMovie))
            } catch (throwable: Throwable) {
                emit(ResultData.Failure(InvalidDataException()))
            }
        }
    }

    override suspend fun setDetailMovieFavorite(isFavorite: Boolean, movieId: Int): Flow<ResultData<String>> {
        return flow {
            movieDao.setDetailMovieFavorite(isFavorite, movieId)
            emit(ResultData.Success(""))
        }
    }

}