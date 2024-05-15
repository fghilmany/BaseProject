package com.fghilmany.baseproject.feature.moviedetail.domain

import com.fghilmany.baseproject.common.ResultData
import kotlinx.coroutines.flow.Flow

interface LoadDetailMovie {
    suspend fun loadDetailMovie(movieId: Int): Flow<ResultData<DetailMovie>>
}