package com.keepcoding.imgram.data.local

import com.example.tdbmkotlin.model.bbdd.MovieItemLocalData
import com.example.tdbmkotlin.model.bbdd.TvShowItemLocalData
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: TheMovieDBDAO) {

    /** TV Shows Functions **/

    fun getTvShows(): List<TvShowItemLocalData> {
        return dao.getTvShows()
    }

//    fun getTvShowById(id: Long){
//        return dao.getTvShowById(id)
//    }

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

    /** Popular Movies Functions **/
    fun getPopularMovie(): List<MovieItemLocalData> {
        return dao.getPopularMovies()
    }

    fun insertPopularMovies(itemLocalData: List<MovieItemLocalData>) {
        dao.insertPopularMovies(itemLocalData)
    }

    fun deleteAllMovies(){
        dao.deleteAllMovies()
    }


}