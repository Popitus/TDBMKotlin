package com.keepcoding.imgram.data.local

import com.example.tdbmkotlin.model.TvShowItemLocalData
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: TheMovieDBDAO) {

    /** Functions **/

    fun getTvShows(): List<TvShowItemLocalData> {
        return dao.getTvShows()
    }

    fun insertTvShow(itemLocalData: TvShowItemLocalData){
        dao.insertTvShow(itemLocalData)
    }

    fun insertTvShows(itemsLocalData: List<TvShowItemLocalData>){
        dao.insertTvShows(itemsLocalData)
    }

    fun deleteTvShow(itemLocalData: TvShowItemLocalData){
        dao.deleteTvShow(itemLocalData)
    }

    fun deleteTvShowById(id: Long){
        dao.deleteTvShowById(id)
    }

    fun deleteAllTvShowS(){
        dao.deleteAllTvShows()
    }
}