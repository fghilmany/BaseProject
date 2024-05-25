package com.fghilmany.baseproject.feature.moviedetail.api

import com.fghilmany.baseproject.feature.moviedetail.domain.DetailMovie
import com.fghilmany.baseproject.feature.moviedetail.domain.Genre

fun RemoteDetailMovie.toDomain() = with(this){
    DetailMovie(
        id,
        backdropPath,
        title,
        releaseDate,
        genres.map { genres -> genres.toDomain() },
        overview
    )
}

fun RemoteGenre.toDomain() = with(this){
    Genre(
        id,
        genre
    )
}