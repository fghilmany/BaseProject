package com.fghilmany.baseproject.feature.moviedetail.cache

import com.fghilmany.baseproject.feature.moviedetail.domain.DetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.Genre

fun DetailMovie.toAppLogic() = with(this){
    LocalDetailMovie(
        id,
        backdropPath,
        title,
        releaseDate,
        genres.map { genres -> genres.toAppLogic(id) },
        overview
    )
}

fun Genre.toAppLogic(movieId: Int) = with(this){
    LocalGenre(
        id,
        movieId,
        name
    )
}