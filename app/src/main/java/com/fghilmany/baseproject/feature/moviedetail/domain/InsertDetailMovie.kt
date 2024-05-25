package com.fghilmany.baseproject.feature.moviedetail.domain

import com.fghilmany.baseproject.common.ResultData
import kotlinx.coroutines.flow.Flow

interface InsertDetailMovie {
    suspend fun saveDetailMovie(detailMovie: DetailMovie)
    suspend fun setDetailMovieFavorite(isFavorite: Boolean, movieId: Int): Flow<ResultData<String>>
}