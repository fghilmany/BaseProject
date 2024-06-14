package com.fghilmany.moviedetail.cache

fun com.fghilmany.moviedetail.domain.DetailMovie.toAppLogic() = with(this){
    LocalDetailMovie(
        id = id,
        backdropPath = backdropPath,
        title = title,
        releaseDate = releaseDate,
        genres = genres.map { genres -> genres.toAppLogic(id) },
        overview = overview,
        isFavorite = isFavorite
    )
}

fun com.fghilmany.moviedetail.domain.Genre.toAppLogic(movieId: Int) = with(this){
    LocalGenre(
        id,
        movieId,
        name
    )
}

fun LocalDetailMovie.toDomain() = with(this){
    com.fghilmany.moviedetail.domain.DetailMovie(
        id = id,
        backdropPath = backdropPath,
        title = title,
        releaseDate = releaseDate,
        genres = genres.map { genres -> genres.toDomain() },
        overview = overview,
        isFavorite = isFavorite
    )
}


fun LocalGenre.toDomain() = with(this){
    com.fghilmany.moviedetail.domain.Genre(
        id = id,
        name
    )
}