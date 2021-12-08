package com.example.tdbmkotlin.data

import android.util.Log
import com.example.tdbmkotlin.mappers.data.MovieDataMapper
import com.example.tdbmkotlin.mappers.data.TvShowDataMapper
import com.example.tdbmkotlin.model.bbdd.MovieItemLocalData
import com.example.tdbmkotlin.model.bbdd.TvShowItemLocalData
import com.keepcoding.imgram.data.local.LocalDataSource
import com.keepcoding.imgram.data.remote.RemoteDataSource
import com.keepcoding.imgram.model.data.MovieItemData
import com.keepcoding.imgram.model.data.TvShowItemData
import com.keepcoding.imgram.model.network.MovieItemNetworkData
import com.keepcoding.imgram.model.network.TvShowItemNetworkData
import javax.inject.Inject
import kotlin.math.log

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val tvShowDataMapper: TvShowDataMapper,
    private val movieDataMapper: MovieDataMapper
){

    /** Functions **/

    // TvShows
    suspend fun getTvShows(): List<TvShowItemData> {
        val result = arrayListOf<TvShowItemData>()
        result.addAll(tvShowDataMapper.mapLocalToData(getLocalTvShows()))

        if (result.isEmpty()) {
            val remote = tvShowDataMapper.mapNetworkToData(getRemoteTvShows())
            localDataSource.insertTvShows(tvShowDataMapper.mapDataToLocal(remote))
            result.addAll(tvShowDataMapper.mapLocalToData(getLocalTvShows()))
        }
        return result
    }

    suspend fun getTvShow(id: Long) {
        localDataSource.getTvShow(id)
    }

    // Movies

    suspend fun getPopularMovies(): List<MovieItemData> {
        val result = arrayListOf<MovieItemData>()
        result.addAll(movieDataMapper.mapLocalToData(getLocalPopularMovies()))
        if (result.isEmpty()) {
            val remote = movieDataMapper.mapNetworkToData(getRemotePopularMovies())
            localDataSource.insertPopularMovies(movieDataMapper.mapDataToLocal(remote))
            result.addAll(movieDataMapper.mapLocalToData(getLocalPopularMovies()))
        }
        return result
    }

    /** Private Functions **/

    // TvShows
    private suspend fun getLocalTvShows(): List<TvShowItemLocalData> {
        val localResult = localDataSource.getTvShows()
        Log.d("Repository", "Resultados series locales: ${localResult.size}")
        return localResult
    }

    private suspend fun getRemoteTvShows(): List<TvShowItemNetworkData> {
        val remoteResult = remoteDataSource.getTopShows()
        Log.d("Repository", "Resultados series remotos: ${remoteResult.size}")
        return remoteResult
    }

    // Movies
    private suspend fun getLocalPopularMovies(): List<MovieItemLocalData> {
        val localResult = localDataSource.getPopularMovie()
        Log.d("Repository", "Resultados movies locales: ${localResult.size}")
        return localResult
    }

    private suspend fun getRemotePopularMovies(): List<MovieItemNetworkData> {
        val remoteResult = remoteDataSource.getPopularMovies()
        Log.d("Repository", "Resultados movies remotos: ${remoteResult.size}")
        return remoteResult
    }




}