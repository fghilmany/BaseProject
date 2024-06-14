
package com.fghilmany.movielist.api

import com.fghilmany.movielist.domain.Movie

fun List<RemoteMovie>.toDomain() = this.map { item ->
    with(item){
        Movie(
            id,
            posterPath,
            title,
            releaseDate,
            overview
        )
    }
}