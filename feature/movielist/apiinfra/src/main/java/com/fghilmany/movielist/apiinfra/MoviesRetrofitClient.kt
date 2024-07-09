package com.fghilmany.movielist.apiinfra

import com.fghilmany.common.*
import com.fghilmany.common.exception.*
import com.fghilmany.movielist.api.MoviesHttpClient
import com.fghilmany.movielist.api.RemoteMovie
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviesRetrofitClient @Inject constructor(
    private val movieClient: HttpClient
): MoviesHttpClient {
    override fun loadMovies(): Flow<ResultData<List<RemoteMovie>>> = flow{
        val service = movieClient.get("discover/movie").body<MovieResponse>()
        try {
            val listMovie = service.results?.map { it.toAppLogic() }
            if (listMovie != null){
                emit(ResultData.Success(listMovie))
            }else{
                emit(ResultData.Failure(DataEmptyException()))
            }
        } catch (throwable: Throwable) {
            when(throwable) {
                is IOException -> {
                    emit(ResultData.Failure(ConnectivityException()))
                }
                is HttpException -> {
                    if (throwable.code() == 422) {
                        emit(ResultData.Failure(InvalidDataException()))
                    }
                }
                else -> {
                    emit(ResultData.Failure(InvalidDataException()))
                }
            }
        }
    }

}