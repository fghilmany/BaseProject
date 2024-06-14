package com.fghilmany.moviedetail.domain

import com.fghilmany.common.ResultData
import kotlinx.coroutines.flow.Flow

interface InsertDetailMovie {
    suspend fun saveDetailMovie(detailMovie: DetailMovie)
    suspend fun setDetailMovieFavorite(isFavorite: Boolean, movieId: Int): Flow<ResultData<String>>
}