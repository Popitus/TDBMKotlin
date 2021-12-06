package com.keepcoding.imgram.data.remote

import com.example.tdbmkotlin.model.PagedResultData
import com.keepcoding.imgram.model.network.MovieItemNetworkData
import com.keepcoding.imgram.model.network.TvShowItemNetworkData
import retrofit2.http.GET

interface TheMovieDBApi {

    // Tv Shows
    @GET("/3/tv/top_rated")
    suspend fun getTopRatedTvShows(): PagedResultData<TvShowItemNetworkData>

    // Movies
    @GET("/3/movie/popular")
    suspend fun getPopularMovies(): PagedResultData<MovieItemNetworkData>
}
