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
import kotlin.random.Random

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
        println("Oliver -> id ${id}")

        if (intent.getStringExtra("name") != null) {
            with (binding) {
                tvShowTitle.text = intent.getStringExtra("name")
                tvShowRating.rating = intent.getDoubleExtra("voted", 0.0).toFloat()/2

                Glide.with(this@TvShowDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500/${intent.getStringExtra("posterPath")}")
                    .placeholder(ContextCompat.getDrawable(this@TvShowDetailActivity, R.mipmap.ic_launcher))
                    .into(tvShowBackdrop)

                Glide.with(this@TvShowDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500/${intent.getStringExtra("posterPath")}")
                    .placeholder(ContextCompat.getDrawable(this@TvShowDetailActivity, R.mipmap.ic_launcher))
                    .into(tvShowPoster)


                progress.visible(true)
                tvShowPosterCardRecommedation.visible(false)
                tvShowOverviewRecommendation.visible(false)
            }
            favorited = intent.getBooleanExtra("favorited",false)
            if (favorited) {
                binding.buttonFavorite.text = "Remove TvShow"
            } else {
                binding.buttonFavorite.text = "Add TvShow"
            }

            viewModel.getTvShowById(id)

        }

        viewModel.images.observe(this) {
            binding.tvShowOverview.text = it.overview
            val itemTvShowPresentation = it

            binding.buttonFavorite.setOnClickListener{
                if (favorited) {
                    viewModel.favoriteTvShow(itemTvShowPresentation, !favorited)
                } else {
                    viewModel.favoriteTvShow(itemTvShowPresentation, !favorited)
                }

                if (binding.buttonFavorite.text == "Add TvShow") {
                    binding.buttonFavorite.text = "Remove TvShow"
                } else {
                    binding.buttonFavorite.text = "Add TvShow"
                }

            }

        }

        viewModel.imagesRecommendation.observe(this) {

            val randomIndex = Random.nextInt(it.size)
            val result = it[randomIndex]
            binding.tvShowOverviewRecommendation.text = result.overview
            Glide.with(this@TvShowDetailActivity)
                .load("https://image.tmdb.org/t/p/w500/${result.posterPath}")
                .placeholder(ContextCompat.getDrawable(this@TvShowDetailActivity, R.mipmap.ic_launcher))
                .into(binding.tvShowPosterSuggestion)
            binding.tvShowRecommendationNameText.text = result.name
            binding.tvShowReleaseDate.text = result.firstDate

            binding.progress.visible(false)
            binding.tvShowPosterCardRecommedation.visible(true)
            binding.tvShowOverviewRecommendation.visible(true)

        }





    }
}