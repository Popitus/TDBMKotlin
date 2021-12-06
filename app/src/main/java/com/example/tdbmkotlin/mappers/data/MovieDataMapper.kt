package com.example.tdbmkotlin.mappers.data

import com.example.tdbmkotlin.model.bbdd.MovieItemLocalData
import com.keepcoding.imgram.model.data.MovieItemData
import com.keepcoding.imgram.model.network.MovieItemNetworkData
import javax.inject.Inject

class MovieDataMapper @Inject constructor() {

    /** Functions **/

    // Network -> Data
    fun mapNetworkToData(networkList: List<MovieItemNetworkData>): List<MovieItemData> {
        return networkList.map { mapNetworkToData(it) }
    }

    // Local -> Data
    fun mapLocalToData(localList: List<MovieItemLocalData>) : List<MovieItemData> {
        return localList.map { mapLocalToData(it) }
    }

    // Data -> Local
    fun mapDataToLocal(localList: List<MovieItemData>): List<MovieItemLocalData> {
        return  localList.map { mapDataToLocal(it) }
    }


    /** Private Functions **/

    // Network -> Data
    private fun mapNetworkToData(network: MovieItemNetworkData): MovieItemData {
        return MovieItemData(network.id, network.title, network.posterPath, network.popularity, network.releaseDate)
    }

    // Local -> Data
    private fun mapLocalToData(local: MovieItemLocalData): MovieItemData {
        return MovieItemData(local.id, local.title, local.posterPath, local.popularity, local.releaseDate)
    }

    // Data -> Local
    private fun mapDataToLocal(local: MovieItemData) : MovieItemLocalData {
        return MovieItemLocalData(local.id, local.title, local.posterPath, local.popularity, local.releaseDate)
    }
}