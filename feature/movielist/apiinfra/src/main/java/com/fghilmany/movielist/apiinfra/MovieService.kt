package com.fghilmany.movielist.apiinfra

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import retrofit2.http.GET

/*interface MovieService {

    @GET("discover/movie")
    suspend fun getListMovie(): MovieResponse
}*/

class MovieServiceImpl(private val ktor: HttpClient): MovieService {
    override suspend fun getListMovie(): Result<MovieResponse> {
        return kotlin.runCatching {
            ktor.get("discover/movie").body<MovieResponse>()
        }
    }

}

interface MovieService {
    suspend fun getListMovie(): Result<MovieResponse>

}