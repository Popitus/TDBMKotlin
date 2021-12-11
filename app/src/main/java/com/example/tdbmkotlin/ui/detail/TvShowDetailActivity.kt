package com.example.tdbmkotlin.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import com.bumptech.glide.Glide
import com.example.tdbmkotlin.R
import com.example.tdbmkotlin.databinding.DetailViewBinding
import com.example.tdbmkotlin.utils.randomTvShow
import com.keepcoding.imgram.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowDetailActivity: AppCompatActivity() {

    /** Properties **/

    private lateinit var binding: DetailViewBinding
    private val viewModel: TvShowDetailViewModel by viewModels()
    private var favorited: Boolean = false

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
                linearLayoutOverview.visible(false)
                linearLayoutRecommend.visible(false)
            }
            favorited = intent.getBooleanExtra("favorited",false)
            if (favorited) {
                binding.buttonFavorite.text = "remove"
            } else {
                binding.buttonFavorite.text = "add"
            }

            viewModel.getTvShowById(id)

        }

        viewModel.images.observe(this) {
            binding.textOverview.text = it.overview
            binding.linearLayoutOverview.visible(true)
            binding.linearLayoutRecommend.visible(true)
            binding.progress.visible(false)

            val itemTvShowPresentation = it

            binding.buttonFavorite.setOnClickListener{
                if (favorited) {
                    viewModel.favoriteTvShow(itemTvShowPresentation, !favorited)
                } else {
                    viewModel.favoriteTvShow(itemTvShowPresentation, !favorited)
                }

                if (binding.buttonFavorite.text == "add") {
                    binding.buttonFavorite.text = "remove"
                } else {
                    binding.buttonFavorite.text = "add"
                }

            }

        }

        viewModel.imagesRecommendation.observe(this) {

            binding.tvShowFirst.text = randomTvShow(it)
            binding.tvShowSecond.text = randomTvShow(it)
            binding.tvShowThird.text = randomTvShow(it)

        }





    }
}