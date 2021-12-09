package com.keepcoding.imgram.data.remote

import com.example.tdbmkotlin.model.PagedResultData
import com.keepcoding.imgram.model.network.MovieItemNetworkData
import com.keepcoding.imgram.model.network.TvShowItemNetworkData
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDBApi {

    // Tv Shows
    @GET("/3/tv/top_rated")
    suspend fun getTopRatedTvShows(): PagedResultData<TvShowItemNetworkData>

    @GET("3/tv/{tv_id}")
    suspend fun getTvShowById(@Path("tv_id") id: Long): TvShowItemNetworkData

    @GET("3/tv/{tv_id}/recommendations")
    suspend fun getTvShowRecommendationById(@Path("tv_id") id: Long): PagedResultData<TvShowItemNetworkData>

    // Movies
    @GET("/3/movie/popular")
    suspend fun getPopularMovies(): PagedResultData<MovieItemNetworkData>


}
