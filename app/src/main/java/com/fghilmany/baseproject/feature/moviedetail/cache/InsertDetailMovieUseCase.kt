package com.fghilmany.baseproject.feature.moviedetail.cache

import com.fghilmany.baseproject.common.ResultData
import com.fghilmany.baseproject.feature.moviedetail.domain.DetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.InsertDetailMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertDetailMovieUseCase @Inject constructor(
    private val detailMovieLocalClient: DetailMovieLocalClient
): InsertDetailMovie {
    override suspend fun saveDetailMovie(detailMovie: DetailMovie) {
        return detailMovieLocalClient.saveDetailMovie(detailMovie.toAppLogic())
    }

    override suspend fun setDetailMovieFavorite(
        isFavorite: Boolean,
        movieId: Int
    ): Flow<ResultData<String>> {
        return detailMovieLocalClient.setDetailMovieFavorite(isFavorite, movieId)
    }
}