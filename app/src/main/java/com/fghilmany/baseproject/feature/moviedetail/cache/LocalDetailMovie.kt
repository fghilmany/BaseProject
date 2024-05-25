package com.fghilmany.baseproject.feature.moviedetail.cache

data class LocalDetailMovie(
    val id: Int,
    val backdropPath: String,
    val title: String,
    val releaseDate: String,
    val genres: List<LocalGenre>,
    val overview: String,
    var isFavorite: Boolean = false
)

data class LocalGenre(
    val id: Int,
    val movieId: Int,
    val name: String
)