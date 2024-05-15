package com.fghilmany.baseproject.feature.movielist.apiinfra

import com.fghilmany.baseproject.feature.movielist.api.RemoteMovie

fun ResultsItem.toAppLogic() = with(this){
    RemoteMovie(
        id,
        posterPath,
        title,
        releaseDate,
        overview
    )
}
