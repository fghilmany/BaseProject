package com.fghilmany.moviedetail.cache

import com.fghilmany.common.ResultData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertDetailMovieUseCase @Inject constructor(
    private val detailMovieLocalClient: DetailMovieLocalClient
): com.fghilmany.moviedetail.domain.InsertDetailMovie {
    override suspend fun saveDetailMovie(detailMovie: com.fghilmany.moviedetail.domain.DetailMovie) {
        return detailMovieLocalClient.saveDetailMovie(detailMovie.toAppLogic())
    }

    override suspend fun setDetailMovieFavorite(
        isFavorite: Boolean,
        movieId: Int
    ): Flow<ResultData<String>> {
        return detailMovieLocalClient.setDetailMovieFavorite(isFavorite, movieId)
    }
}