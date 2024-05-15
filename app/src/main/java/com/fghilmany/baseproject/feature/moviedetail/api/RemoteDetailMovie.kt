package com.fghilmany.baseproject.feature.moviedetail.api

data class RemoteDetailMovie(
    val id: Int,
    val backdropPath: String,
    val title: String,
    val releaseDate: String,
    val genres: List<RemoteGenres>,
    val overview: String
)

data class RemoteGenres(
    val id: Int,
    val genre: String
)
