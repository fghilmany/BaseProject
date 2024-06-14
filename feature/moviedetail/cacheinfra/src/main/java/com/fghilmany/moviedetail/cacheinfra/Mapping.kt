package com.fghilmany.moviedetail.cacheinfra

import com.fghilmany.moviedetail.cache.LocalDetailMovie
import com.fghilmany.moviedetail.cache.LocalGenre

fun com.fghilmany.moviedetail.cache.LocalGenre.toDao() = with(this){
    LocalGenreEntity(
        genreId = id,
        movieId = movieId,
        name = name
    )
}

fun com.fghilmany.moviedetail.cache.LocalDetailMovie.toDao() = with(this){
    DetailMovieEntity(
        id,
        backdropPath,
        title,
        releaseDate,
        overview,
        isFavorite
    )
}

fun DetailMovieWithGenres.toAppLogic() = with(this.detailMovieEntity){
    com.fghilmany.moviedetail.cache.LocalDetailMovie(
        id,
        backdropPath,
        title,
        releaseDate,
        overview,
        isFavorite,
        this@toAppLogic.genres.map { genre ->
            with(genre) {
                com.fghilmany.moviedetail.cache.LocalGenre(
                    id, movieId, name
                )
            }
        }
    )
}