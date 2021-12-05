package com.keepcoding.imgram.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tdbmkotlin.model.TvShowItemLocalData

@Dao
interface TheMovieDBDAO {

    /** Functions **/

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
}