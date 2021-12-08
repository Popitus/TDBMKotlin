package com.example.tdbmkotlin.utils

import com.example.tdbmkotlin.model.presentation.TvShowPresentation

interface DetailTvShowClickListener {

    fun onClick(tvShowItemData: TvShowPresentation)
}