package com.example.tdbmkotlin.model.presentation

data class TvShowPresentation(
    var id: Long?,
    var name: String?,
    var posterPath: String?,
    var voted: Double?,
    var overview: String?,
    var favorited: Boolean?,
)