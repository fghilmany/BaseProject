package com.fghilmany.baseproject.feature.movielist.api

import com.fghilmany.baseproject.common.ResultData
import kotlinx.coroutines.flow.Flow

interface MoviesHttpClient {
    fun loadMovies(): Flow<ResultData<List<RemoteMovie>>>
}