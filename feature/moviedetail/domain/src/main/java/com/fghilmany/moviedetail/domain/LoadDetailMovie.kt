package com.fghilmany.moviedetail.domain

import com.fghilmany.common.ResultData
import kotlinx.coroutines.flow.Flow

interface LoadDetailMovie {
    suspend fun loadDetailMovie(movieId: Int): Flow<ResultData<DetailMovie>>
}