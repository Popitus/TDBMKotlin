package com.example.tdbmkotlin.ui.tvshows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tdbmkotlin.R
import com.example.tdbmkotlin.databinding.ItemListBinding
import com.example.tdbmkotlin.model.presentation.TvShowPresentation

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.ImageViewHolder>() {

    /** Properties **/
    var data = mutableListOf<TvShowPresentation>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapter.ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.ImageViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    /** Functions **/
    fun addAll(items: List<TvShowPresentation>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    /** Class **/
    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        /** Properties of Inner class **/
        private val binding = ItemListBinding.bind(itemView)
        private lateinit var item: TvShowPresentation

        fun bind (item:TvShowPresentation) {
            this.item = item
            with (binding) {
                imageTitle.text = item.name
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/${item.posterPath}")
                    .placeholder(ContextCompat.getDrawable(itemView.context, R.mipmap.ic_launcher))
                    .into(image)
            }
        }

    }

}