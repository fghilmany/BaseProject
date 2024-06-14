package com.fghilmany.movielist.domain

import com.fghilmany.common.ResultData
import kotlinx.coroutines.flow.Flow


interface LoadMovies{
    fun loadMovies(): Flow<ResultData<List<Movie>>>
}

