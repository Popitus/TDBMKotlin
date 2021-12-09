package com.keepcoding.imgram.data.remote

import com.keepcoding.imgram.model.network.MovieItemNetworkData
import com.keepcoding.imgram.model.network.TvShowItemNetworkData
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: TheMovieDBApi) {

    /** TvShows Functions **/

    // Shows (Tops)
    suspend fun getTopShows(): List<TvShowItemNetworkData> {
        val pagedResultData = api.getTopRatedTvShows()
        return pagedResultData.results
    }

    suspend fun getTvShowById(id: Long): TvShowItemNetworkData {
        val pagedResultData = api.getTvShowById(id)
        return pagedResultData
    }

    suspend fun getTvShowRecommendationById(id: Long): List<TvShowItemNetworkData> {
        val pagedResultData = api.getTvShowRecommendationById(id)
        return pagedResultData.results
    }

    /** Movies Functions **/

    suspend fun getPopularMovies(): List<MovieItemNetworkData> {
        val pagedResultData = api.getPopularMovies()
        return pagedResultData.results
    }
}

