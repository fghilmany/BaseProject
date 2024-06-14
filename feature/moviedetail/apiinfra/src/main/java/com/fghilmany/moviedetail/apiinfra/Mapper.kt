package com.fghilmany.moviedetail.apiinfra

import com.fghilmany.moviedetail.api.RemoteDetailMovie
import com.fghilmany.moviedetail.api.RemoteGenre

fun DetailMovieResponse.toAppLogic() = with(this){
    com.fghilmany.moviedetail.api.RemoteDetailMovie(
        id,
        backdropPath ?: posterPath,
        title,
        releaseDate,
        genres.map { genres -> genres.toAppLogic() },
        overview
    )
}

fun GenresItem.toAppLogic() = with(this){
    com.fghilmany.moviedetail.api.RemoteGenre(
        id,
        name
    )
}


