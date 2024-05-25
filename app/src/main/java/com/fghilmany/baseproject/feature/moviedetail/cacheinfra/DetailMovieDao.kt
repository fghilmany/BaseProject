package com.fghilmany.baseproject.feature.moviedetail.cacheinfra

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DetailMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetailMovie(detailMovieEntity: DetailMovieEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenre(genre: List<LocalGenreEntity>)

    @Query("UPDATE movie_detail SET is_favorite = (:isFavorite) WHERE id == (:movieId)")
    suspend fun setDetailMovieFavorite(isFavorite: Boolean, movieId: Int)
}