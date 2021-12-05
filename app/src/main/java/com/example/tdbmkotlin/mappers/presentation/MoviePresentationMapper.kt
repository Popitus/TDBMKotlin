package com.example.tdbmkotlin.mappers.presentation

import com.example.tdbmkotlin.model.presentation.MoviePresentation
import com.keepcoding.imgram.model.data.MovieItemData
import javax.inject.Inject

class MoviePresentationMapper @Inject constructor() {

    fun mapDataToPresentation(data: List<MovieItemData>): List<MoviePresentation> {
        return data.map { mapDataToPresentation(it) }
    }

    fun mapDataToPresentation(data: MovieItemData): MoviePresentation {
        return MoviePresentation(data.id, data.title, data.posterPath, data.popularity, data.releaseDate)
    }

}