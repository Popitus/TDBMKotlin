package com.example.tdbmkotlin.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tdbmkotlin.databinding.DetailViewBinding
import com.keepcoding.imgram.Properties

class DetailActivity: AppCompatActivity() {

    /** Properties **/

    private lateinit var binding: DetailViewBinding

    /** Lifecicle **/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvShowId = intent.getStringExtra(Properties.TV_SHOW)
        binding.textView.text = tvShowId

    }


}