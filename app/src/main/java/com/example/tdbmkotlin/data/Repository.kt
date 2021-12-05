package com.example.tdbmkotlin.data

import android.util.Log
import com.example.tdbmkotlin.mappers.data.MovieDataMapper
import com.example.tdbmkotlin.mappers.data.TvShowDataMapper
import com.example.tdbmkotlin.model.TvShowItemLocalData
import com.keepcoding.imgram.data.local.LocalDataSource
import com.keepcoding.imgram.data.remote.RemoteDataSource
import com.keepcoding.imgram.model.data.TvShowItemData
import com.keepcoding.imgram.model.network.TvShowItemNetworkData
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val tvShowDataMapper: TvShowDataMapper,
    private val movieDataMapper: MovieDataMapper
){

    /** Functions **/

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

    private suspend fun getLocalTvShows(): List<TvShowItemLocalData> {
        val localResult = localDataSource.getTvShows()
        Log.d("Repository", "Resultados locales: ${localResult.size}")
        return localResult
    }

    private suspend fun getRemoteTvShows(): List<TvShowItemNetworkData> {
        val remoteResult = remoteDataSource.getTopShows()
        Log.d("Repository", "Resultados remotos: ${remoteResult.size}")
        return remoteResult
    }




}