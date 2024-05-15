package com.fghilmany.baseproject.feature.movielist.api

import com.fghilmany.baseproject.common.ResultData
import com.fghilmany.baseproject.common.exception.Connectivity
import com.fghilmany.baseproject.common.exception.ConnectivityException
import com.fghilmany.baseproject.common.exception.DataEmpty
import com.fghilmany.baseproject.common.exception.DataEmptyException
import com.fghilmany.baseproject.common.exception.InvalidData
import com.fghilmany.baseproject.common.exception.InvalidDataException
import com.fghilmany.baseproject.feature.movielist.domain.LoadMovies
import com.fghilmany.baseproject.feature.movielist.domain.Movie
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