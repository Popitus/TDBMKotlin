package com.example.tdbmkotlin.mappers.presentation

import com.example.tdbmkotlin.model.presentation.TvShowPresentation
import com.keepcoding.imgram.model.data.TvShowItemData
import com.keepcoding.imgram.model.network.TvShowItemNetworkData
import javax.inject.Inject

class TvShowPresentationMapper @Inject constructor() {

    fun mapDataToPresentation(data: List<TvShowItemData>): List<TvShowPresentation> {
        return data.map { mapDataToPresentation(it) }
    }

    fun mapDataToPresentation(data: TvShowItemData): TvShowPresentation {
        return TvShowPresentation(data.id,
            data.name,
            data.posterPath,
            data.voted,
            data.overview)
    }

    fun mapPresentationToData(presentation: TvShowPresentation): TvShowItemData {
        return TvShowItemData(presentation.id,
            presentation.name,
            presentation.posterPath,
            presentation.voted,
            presentation.overview)
    }

    fun mapNetWorkToPresentation(data: List<TvShowItemNetworkData>): List<TvShowPresentation> {
        return data.map { mapNetWorkToPresentation(it) }
    }

    fun mapNetWorkToPresentation(data: TvShowItemNetworkData): TvShowPresentation {
        return TvShowPresentation(data.id,
            data.name,
            data.posterPath,
            data.voteAverage,
            data.overview)
    }


}