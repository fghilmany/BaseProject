package com.fghilmany.baseproject.feature.movielist.apiinfra

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface MovieService {

    @GET("discover/movie")
    suspend fun getListMovie(): MovieResponse
}