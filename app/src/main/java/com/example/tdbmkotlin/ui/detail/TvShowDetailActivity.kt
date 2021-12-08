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
                idText.text = intent.getLongExtra("id", 0).toString()


                Glide.with(this@TvShowDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500/${intent.getStringExtra("posterPath")}")
                    .placeholder(ContextCompat.getDrawable(this@TvShowDetailActivity, R.mipmap.ic_launcher))
                    .into(imagePosterBig)

                Glide.with(this@TvShowDetailActivity)
                    .load("https://image.tmdb.org/t/p/w500/${intent.getStringExtra("posterPath")}")
                    .placeholder(ContextCompat.getDrawable(this@TvShowDetailActivity, R.mipmap.ic_launcher))
                    .into(imagePoster)

                votedRating.text = intent.getDoubleExtra("voted", 0.0).toString()
            }

            viewModel.getTvShowById(id)
        }

//        viewModel.images.observe(this) {
//            println("${it}")
//        }

    }

}