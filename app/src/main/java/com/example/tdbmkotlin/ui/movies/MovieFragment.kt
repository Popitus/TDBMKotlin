package com.example.tdbmkotlin.ui.movies

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
class MovieFragment: Fragment(R.layout.fragment_main) {

    /** Properties **/
    private val binding: FragmentMainBinding by viewBinding()
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var imageAdapter: MovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageAdapter = MovieAdapter()

        /** Binding **/
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
