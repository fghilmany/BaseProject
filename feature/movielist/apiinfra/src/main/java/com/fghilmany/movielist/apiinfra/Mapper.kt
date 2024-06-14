package com.fghilmany.movielist.apiinfra

fun ResultsItem.toAppLogic() = with(this){
    com.fghilmany.movielist.api.RemoteMovie(
        id,
        posterPath,
        title,
        releaseDate,
        overview
    )
}
