package com.fghilmany.baseproject.common

import com.fghilmany.baseproject.feature.movielist.domain.Movie

sealed class ResultData<T>{
    data class Success<T>(val data: T) : ResultData<T>()
    data class Failure<T>(val throwable: Throwable) : ResultData<T>()
}