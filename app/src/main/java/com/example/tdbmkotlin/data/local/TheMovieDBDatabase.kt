package com.keepcoding.imgram.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tdbmkotlin.model.bbdd.MovieItemLocalData
import com.example.tdbmkotlin.model.bbdd.TvShowItemLocalData


@Database(
    entities = [TvShowItemLocalData::class, MovieItemLocalData::class],
    version = 1
)
abstract class TheMovieDBDatabase : RoomDatabase() {
    abstract fun tmdbDao(): TheMovieDBDAO
}

