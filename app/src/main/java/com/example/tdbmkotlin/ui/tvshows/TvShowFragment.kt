package com.example.tdbmkotlin.ui.tvshows

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tdbmkotlin.R
import com.example.tdbmkotlin.databinding.FragmentMainBinding
import com.example.tdbmkotlin.model.presentation.TvShowPresentation
import com.example.tdbmkotlin.ui.commons.viewBinding
import com.example.tdbmkotlin.ui.detail.DetailActivity
import com.example.tdbmkotlin.utils.DetailTvShowClickListener
import com.keepcoding.imgram.Properties
import com.keepcoding.imgram.model.data.TvShowItemData
import com.keepcoding.imgram.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment: Fragment(R.layout.fragment_main) {

    /** Properties **/
    private val binding: FragmentMainBinding by viewBinding()
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var imageAdapter: TvShowAdapter


    /** Lifecicle **/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageAdapter = TvShowAdapter {
            viewModel
        }

        /** binding **/
        with(binding) {
            imageList.adapter = imageAdapter
            imageList.layoutManager = GridLayoutManager(context, 2)
            progress.visible(true)
        }

        viewModel.images.observe(this) {
            imageAdapter.addAll(it)
            binding.progress.visible(false)
        }

    }
}