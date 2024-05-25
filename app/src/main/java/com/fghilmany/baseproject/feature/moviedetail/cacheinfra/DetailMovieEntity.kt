package com.fghilmany.baseproject.feature.moviedetail.cacheinfra

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_detail")
data class DetailMovieEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)
@Entity(tableName = "movie_detail_genre")
data class LocalGenreEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "genre_id")
    val genreId: Int,
    @ColumnInfo(name = "movie_id")
    val movieId: Int,
    @ColumnInfo(name = "name")
    val name: String
)