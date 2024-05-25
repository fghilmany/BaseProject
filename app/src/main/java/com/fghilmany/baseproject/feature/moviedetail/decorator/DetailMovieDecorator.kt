package com.fghilmany.baseproject.feature.moviedetail.decorator

import com.fghilmany.baseproject.common.ResultData
import com.fghilmany.baseproject.feature.moviedetail.domain.DetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.InsertDetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.LoadDetailMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailMovieDecorator @Inject constructor(
    private val decorator: LoadDetailMovie,
    private val local: InsertDetailMovie
): LoadDetailMovie {
    override suspend fun loadDetailMovie(movieId: Int): Flow<ResultData<DetailMovie>> {
        return flow {
            decorator.loadDetailMovie(movieId).collect{ response ->
                if(response is ResultData.Success)
                    local.saveDetailMovie(response.data)
                emit(response)
            }
        }
    }
}