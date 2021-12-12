package com.example.tdbmkotlin.utils

import com.example.tdbmkotlin.model.presentation.TvShowPresentation
import kotlin.random.Random

fun randomTvShow(lista: List<TvShowPresentation>): TvShowPresentation {

    val randomIndex = Random.nextInt(lista.size)
    return lista[randomIndex]

}

