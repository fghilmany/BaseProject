package com.fghilmany.baseproject.feature.moviedetail.cacheinfra

import com.fghilmany.baseproject.feature.moviedetail.cache.LocalDetailMovie
import com.fghilmany.baseproject.feature.moviedetail.cache.LocalGenre

fun LocalGenre.toDao() = with(this){
    LocalGenreEntity(
        genreId = id,
        movieId = movieId,
        name = name
    )
}

fun LocalDetailMovie.toDao() = with(this){
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
    LocalDetailMovie(
        id,
        backdropPath,
        title,
        releaseDate,
        overview,
        isFavorite,
        this@toAppLogic.genres.map { genre -> with(genre){
            LocalGenre(
                id, movieId, name
            )
        } }
    )
}