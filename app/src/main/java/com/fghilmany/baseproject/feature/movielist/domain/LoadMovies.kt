package com.fghilmany.baseproject.feature.movielist.domain

import com.fghilmany.baseproject.common.ResultData
import kotlinx.coroutines.flow.Flow


interface LoadMovies{
    fun loadMovies(): Flow<ResultData<List<Movie>>>
}

