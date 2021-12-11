package com.example.tdbmkotlin.mappers.data

import com.example.tdbmkotlin.model.bbdd.TvShowItemLocalData
import com.keepcoding.imgram.model.data.TvShowItemData
import com.keepcoding.imgram.model.network.TvShowItemNetworkData
import javax.inject.Inject

class TvShowDataMapper @Inject constructor() {

    private fun mapLocalToData(local: TvShowItemLocalData): TvShowItemData {
        return TvShowItemData(local.id, local.name, local.posterPath, local.voted, local.overview, local.favorited)
    }

    fun mapLocalToData(localList: List<TvShowItemLocalData>): List<TvShowItemData> {
        return localList.map { mapLocalToData(it) }
    }

    fun mapDataToLocal(local: TvShowItemData): TvShowItemLocalData {
        return TvShowItemLocalData(local.id, local.name, local.posterPath, local.voted, local.overview, local.favorited)
    }

    fun mapDataToLocal(localList: List<TvShowItemData>): List<TvShowItemLocalData> {
        return localList.map { mapDataToLocal(it) }
    }

    private fun mapNetworkToData(local: TvShowItemNetworkData): TvShowItemData {
        return TvShowItemData(local.id, local.name, local.posterPath, local.voteAverage,local.overview, false)
    }

    fun mapNetworkToData(localList: List<TvShowItemNetworkData>): List<TvShowItemData> {
        return localList.map { mapNetworkToData(it) }
    }
}