package com.fghilmany.common

sealed class ResultData<T>{
    data class Success<T>(val data: T) : ResultData<T>()
    data class Failure<T>(val throwable: Throwable) : ResultData<T>()
}