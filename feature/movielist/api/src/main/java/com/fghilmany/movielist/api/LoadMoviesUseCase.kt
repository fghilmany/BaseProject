package com.fghilmany.movielist.api

import com.fghilmany.common.*
import com.fghilmany.common.exception.Connectivity
import com.fghilmany.common.exception.ConnectivityException
import com.fghilmany.common.exception.DataEmpty
import com.fghilmany.common.exception.DataEmptyException
import com.fghilmany.common.exception.InvalidData
import com.fghilmany.common.exception.InvalidDataException
import com.fghilmany.movielist.domain.LoadMovies
import com.fghilmany.movielist.domain.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoadMoviesUseCase @Inject constructor(
    private val moviesHttpClient: MoviesHttpClient
): LoadMovies {
    override fun loadMovies(): Flow<ResultData<List<Movie>>> = flow {
        moviesHttpClient.loadMovies().collect{ result ->
            when(result){
                is ResultData.Success-> {
                    emit(ResultData.Success(result.data.toDomain()))
                }

                is ResultData.Failure -> {
                    when(result.throwable){
                        is InvalidDataException -> {
                            emit(ResultData.Failure(InvalidData()))
                        }
                        is ConnectivityException -> {
                            emit(ResultData.Failure(Connectivity()))
                        }
                        is DataEmptyException -> {
                            emit(ResultData.Failure(DataEmpty()))
                        }
                    }
                }
            }
        }
    }
}