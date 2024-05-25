package com.fghilmany.baseproject.feature.moviedetail.cacheinfra

import com.fghilmany.baseproject.common.ResultData
import com.fghilmany.baseproject.feature.moviedetail.cache.DetailMovieLocalClient
import com.fghilmany.baseproject.feature.moviedetail.cache.LocalDetailMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailMovieRoomClient @Inject constructor(
    private val movieDao: DetailMovieDao
): DetailMovieLocalClient {
    override suspend fun saveDetailMovie(detailMovie: LocalDetailMovie) {
        movieDao.insertDetailMovie(detailMovie.toDao())
        movieDao.insertGenre(detailMovie.genres.map { genre -> genre.toDao() })
    }



    override suspend fun setDetailMovieFavorite(isFavorite: Boolean, movieId: Int): Flow<ResultData<String>> {
        return flow {
            movieDao.setDetailMovieFavorite(isFavorite, movieId)
            emit(ResultData.Success(""))
        }
    }

}