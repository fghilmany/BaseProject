package com.fghilmany.moviedetail.api

import com.fghilmany.common.ResultData
import kotlinx.coroutines.flow.Flow

interface DetailMovieHttpClient {
    fun loadDetailMovie(movieId: Int): Flow<ResultData<RemoteDetailMovie>>
}