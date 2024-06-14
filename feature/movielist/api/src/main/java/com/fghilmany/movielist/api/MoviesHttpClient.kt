package com.fghilmany.movielist.api

import com.fghilmany.common.ResultData
import kotlinx.coroutines.flow.Flow

interface MoviesHttpClient {
    fun loadMovies(): Flow<ResultData<List<RemoteMovie>>>
}