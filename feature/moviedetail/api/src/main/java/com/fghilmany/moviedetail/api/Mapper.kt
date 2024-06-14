package com.fghilmany.moviedetail.api

import com.fghilmany.moviedetail.domain.DetailMovie
import com.fghilmany.moviedetail.domain.Genre

fun RemoteDetailMovie.toDomain() = with(this){
    com.fghilmany.moviedetail.domain.DetailMovie(
        id,
        backdropPath,
        title,
        releaseDate,
        genres.map { genres -> genres.toDomain() },
        overview
    )
}

fun RemoteGenre.toDomain() = with(this){
    com.fghilmany.moviedetail.domain.Genre(
        id,
        genre
    )
}