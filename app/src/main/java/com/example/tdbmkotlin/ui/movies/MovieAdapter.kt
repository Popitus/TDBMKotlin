package com.example.tdbmkotlin.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tdbmkotlin.R
import com.example.tdbmkotlin.databinding.ItemMovieBinding
import com.example.tdbmkotlin.model.presentation.MoviePresentation

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ImageViewHolder>() {

    /** Properties **/
    var data = mutableListOf<MoviePresentation>()

    /** ViewHolder functions **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ImageViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    /** Functions **/
    fun addAll(items: List<MoviePresentation>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    /** Inner Class **/
    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        /** Properties of Inner class **/
        private val binding = ItemMovieBinding.bind(itemView)
        private lateinit var item: MoviePresentation

        fun bind (item: MoviePresentation) {
            this.item = item
            with (binding) {
                imageTitle.text = item.title
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/${item.posterPath}")
                    .placeholder(ContextCompat.getDrawable(itemView.context, R.mipmap.ic_launcher))
                    .into(image)

                popularityStar.text = "%.2f".format(item.popularity)
            }
        }

    }
}