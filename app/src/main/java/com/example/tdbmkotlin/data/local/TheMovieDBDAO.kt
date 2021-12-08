package com.keepcoding.imgram.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tdbmkotlin.model.bbdd.MovieItemLocalData
import com.example.tdbmkotlin.model.bbdd.TvShowItemLocalData

@Dao
interface TheMovieDBDAO {

    /** TV Shows Functions **/

    @Query("SELECT * FROM tv_shows order by name DESC")
    fun getTvShows(): List<TvShowItemLocalData>

    @Insert
    fun insertTvShow(item: TvShowItemLocalData): Long

    @Insert
    fun insertTvShows(items: List<TvShowItemLocalData>)

    @Delete
    fun deleteTvShow(item: TvShowItemLocalData)

    @Query("Delete from tv_shows where :itemId = id")
    fun deleteTvShowById(itemId: Long)

    @Query("Delete from tv_shows")
    fun deleteAllTvShows()

    /** Movies Functions **/

    @Query("SELECT * FROM movies order by title DESC")
    fun getPopularMovies(): List<MovieItemLocalData>

    @Insert
    fun insertPopularMovie(item: MovieItemLocalData): Long

    @Insert
    fun insertPopularMovies(items: List<MovieItemLocalData>)

    @Query("Delete from movies")
    fun deleteAllMovies()

}