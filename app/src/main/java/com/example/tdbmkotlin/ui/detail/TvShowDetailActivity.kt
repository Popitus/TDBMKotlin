package com.example.tdbmkotlin.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.tdbmkotlin.R
import com.example.tdbmkotlin.databinding.DetailViewBinding
import com.keepcoding.imgram.Properties
import com.keepcoding.imgram.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowDetailActivity: AppCompatActivity() {

    /** Properties **/

    private lateinit var binding: DetailViewBinding
    private val viewModel: TvShowDetailViewModel by viewModels()

    /** Lifecicle **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id = intent.getLongExtra("id", 0)


        if (intent.getStringExtra("name") != null) {
            with (binding) {
                nameText.text = intent.getStringExtra("name")
                //idText.text = intent.getLongExtra("id", 0).toString()
                popularityText.text = "Voted: " + intent.getDoubleExtra("voted", 0.0).toString()



                Glide.with(this@TvShowDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500/${intent.getStringExtra("posterPath")}")
                    .placeholder(ContextCompat.getDrawable(this@TvShowDetailActivity, R.mipmap.ic_launcher))
                    .into(imagePosterBig)

                Glide.with(this@TvShowDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500/${intent.getStringExtra("posterPath")}")
                    .placeholder(ContextCompat.getDrawable(this@TvShowDetailActivity, R.mipmap.ic_launcher))
                    .into(imagePoster)

                progress.visible(true)

            }

            viewModel.getTvShowById(id)
            viewModel.getTvShowRecommendationById(id)
        }

        viewModel.images.observe(this) {
            binding.textOverview.text = it.overview
            binding.progress.visible(false)
        }

        viewModel.imagesRecommendation.observe(this) {
            binding.textPrueba.text = it.toString()
            println("Oliver $it")
        }


    }

}