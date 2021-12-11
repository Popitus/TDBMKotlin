package com.example.tdbmkotlin.utils

import com.example.tdbmkotlin.model.presentation.TvShowPresentation
import kotlin.random.Random

fun randomTvShow(lista: List<TvShowPresentation>): String? {

    val randomIndex = Random.nextInt(lista.size)

    val resultado = lista.map {
        it.name
    }

    return resultado[randomIndex]

}