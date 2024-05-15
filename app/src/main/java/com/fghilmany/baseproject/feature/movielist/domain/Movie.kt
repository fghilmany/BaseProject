package com.fghilmany.baseproject.feature.movielist.domain

data class Movie(
    val id: Int,
    val posterPath: String,
    val title: String,
    val releaseDate: String,
    val overview: String,
)
