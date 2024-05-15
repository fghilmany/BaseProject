package com.fghilmany.baseproject.feature.moviedetail.apiinfra

import com.fghilmany.baseproject.feature.moviedetail.api.RemoteDetailMovie
import com.fghilmany.baseproject.feature.moviedetail.api.RemoteGenres

fun DetailMovieResponse.toAppLogic() = with(this){
    RemoteDetailMovie(
        id,
        backdropPath ?: posterPath,
        title,
        releaseDate,
        genres.map { genres -> genres.toAppLogic() },
        overview
    )
}

fun GenresItem.toAppLogic() = with(this){
    RemoteGenres(
        id,
        name
    )
}


