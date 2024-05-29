package com.fghilmany.baseproject.feature.moviedetail.api

import com.fghilmany.baseproject.common.ResultData
import com.fghilmany.baseproject.common.exception.Connectivity
import com.fghilmany.baseproject.common.exception.ConnectivityException
import com.fghilmany.baseproject.common.exception.DataEmpty
import com.fghilmany.baseproject.common.exception.DataEmptyException
import com.fghilmany.baseproject.common.exception.InvalidData
import com.fghilmany.baseproject.common.exception.InvalidDataException
import com.fghilmany.baseproject.feature.moviedetail.domain.DetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.LoadDetailMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRemoteDetailMovieUseCase @Inject constructor(
    private val detailMovieHttpClient: DetailMovieHttpClient
): LoadDetailMovie {
    override suspend fun loadDetailMovie(movieId: Int): Flow<ResultData<DetailMovie>> = flow {
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