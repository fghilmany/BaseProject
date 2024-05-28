package com.fghilmany.baseproject.feature.moviedetail.cache

import com.fghilmany.baseproject.common.ResultData
import kotlinx.coroutines.flow.Flow

interface DetailMovieLocalClient {
    suspend fun saveDetailMovie(detailMovie: LocalDetailMovie)
    suspend fun setDetailMovieFavorite(isFavorite: Boolean, movieId: Int): Flow<ResultData<String>>
}