package com.example.tdbmkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import com.example.tdbmkotlin.R
import com.example.tdbmkotlin.databinding.ActivityMainBinding
import com.example.tdbmkotlin.utils.DetailTvShowClickListener
import com.example.tdbmkotlin.ui.movies.MovieFragment
import com.example.tdbmkotlin.ui.tvshows.TvShowFragment
import com.keepcoding.imgram.model.data.TvShowItemData
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), DetailTvShowClickListener {

    /** Properties **/
    private lateinit var binding: ActivityMainBinding



    /** Lifecicle **/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** binding - fragment creation **/
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, TvShowFragment::class.java, bundleOf(Pair("key","value")))
            .commit()

        with(binding) {

            /** bottom Navigation **/
            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_tv_shows -> {
                        Log.d("ActivityMain", "Menu top clicked")
                        supportFragmentManager.beginTransaction()
                            .replace(binding.fragmentContainer.id, TvShowFragment::class.java, bundleOf())
                            .commit()
                    }
                    R.id.menu_movies -> {
                        Log.d("ActivityMain", "Menu hot clicked")
                        supportFragmentManager.beginTransaction()
                            .replace(binding.fragmentContainer.id, MovieFragment::class.java, bundleOf())
                            .commit()
                    }
                    R.id.saves_items -> {
                        Log.d("ActivityMain", "Saves Clicked")
                    }
                    else -> {
                        Log.d("ActivityMain", "No deberías estar aqui")
                    }
                }

                false
            }
        }
    }

    override fun onClick(tvShowItemData: TvShowItemData) {
        TODO("Not yet implemented")
    }
}