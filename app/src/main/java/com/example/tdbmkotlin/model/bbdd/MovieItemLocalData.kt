package com.example.tdbmkotlin.model.bbdd

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieItemLocalData(
    @PrimaryKey @ColumnInfo(name = "id") var id: Long?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "poster_path") var posterPath: String?,
    @ColumnInfo(name = "popularity") var popularity: Double?,
    @ColumnInfo(name = "release_date") var releaseDate: String?,
)