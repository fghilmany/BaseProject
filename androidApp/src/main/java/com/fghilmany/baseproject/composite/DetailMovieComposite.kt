package com.fghilmany.baseproject.composite

import com.fghilmany.common.ResultData
import com.fghilmany.moviedetail.domain.DetailMovie
import com.fghilmany.moviedetail.domain.LoadDetailMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class DetailMovieComposite(
    private val primary: LoadDetailMovie,
    private val fallback: LoadDetailMovie
): LoadDetailMovie {
    override suspend fun loadDetailMovie(movieId: Int): Flow<ResultData<DetailMovie>> = flow {
        primary.loadDetailMovie(movieId).collect { result ->
            when(result){
                is ResultData.Success -> emit(result)
                is ResultData.Failure -> emit(fallback.loadDetailMovie(movieId).first())
            }
        }
    }
}