package com.fghilmany.baseproject.feature.moviedetail.api

import com.fghilmany.baseproject.common.ResultData
import kotlinx.coroutines.flow.Flow

interface DetailMovieHttpClient {
    fun loadDetailMovie(movieId: Int): Flow<ResultData<RemoteDetailMovie>>
}