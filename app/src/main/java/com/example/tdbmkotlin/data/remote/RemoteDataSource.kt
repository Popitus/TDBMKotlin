package com.keepcoding.imgram.data.remote

import com.keepcoding.imgram.model.network.MovieItemNetworkData
import com.keepcoding.imgram.model.network.TvShowItemNetworkData
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: TheMovieDBApi) {

    /** Functions **/

    // Shows (Tops)
    suspend fun getTopShows(): List<TvShowItemNetworkData> {
        val pagedResultData = api.getTopRatedTvShows()
        return pagedResultData.results
    }

    // Movies (Popular)
    suspend fun getPopularMovies(): List<MovieItemNetworkData> {
        val pagedResultData = api.getPopularMovies()
        return pagedResultData.results
    }
}

