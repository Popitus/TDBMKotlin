package com.example.tdbmkotlin.mappers.presentation

import com.example.tdbmkotlin.model.presentation.TvShowPresentation
import com.keepcoding.imgram.model.data.TvShowItemData
import javax.inject.Inject

class TvShowPresentationMapper @Inject constructor() {

    fun mapDataToPresentation(data: List<TvShowItemData>): List<TvShowPresentation> {
        return data.map { mapDataToPresentation(it) }
    }

    fun mapDataToPresentation(data: TvShowItemData): TvShowPresentation {
        return TvShowPresentation(data.id, data.name, data.posterPath, data.voted)
    }

    fun mapPresentationToData(presentation: TvShowPresentation): TvShowItemData {
        return TvShowItemData(presentation.id, presentation.name, presentation.posterPath, presentation.voted)
    }
}