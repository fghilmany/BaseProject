package com.fghilmany.moviedetail.api

import com.fghilmany.common.exception.Connectivity
import com.fghilmany.common.exception.ConnectivityException
import com.fghilmany.common.exception.DataEmpty
import com.fghilmany.common.exception.DataEmptyException
import com.fghilmany.common.exception.InvalidData
import com.fghilmany.common.exception.InvalidDataException
import com.fghilmany.common.ResultData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRemoteDetailMovieUseCase @Inject constructor(
    private val detailMovieHttpClient: DetailMovieHttpClient
): com.fghilmany.moviedetail.domain.LoadDetailMovie {
    override suspend fun loadDetailMovie(movieId: Int): Flow<ResultData<com.fghilmany.moviedetail.domain.DetailMovie>> = flow {
        detailMovieHttpClient.loadDetailMovie(movieId).collect{ result ->
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