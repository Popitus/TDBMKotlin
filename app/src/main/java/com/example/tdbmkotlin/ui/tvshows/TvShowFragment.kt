package com.example.tdbmkotlin.ui.tvshows

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tdbmkotlin.R
import com.example.tdbmkotlin.databinding.FragmentMainBinding
import com.example.tdbmkotlin.ui.commons.viewBinding
import com.keepcoding.imgram.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment: Fragment(R.layout.fragment_main) {

    /** Properties **/
    private val binding: FragmentMainBinding by viewBinding()
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var imageAdapter: TvShowAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageAdapter = TvShowAdapter()

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