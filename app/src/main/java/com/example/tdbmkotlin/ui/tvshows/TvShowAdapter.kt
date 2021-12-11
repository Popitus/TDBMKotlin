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

class TvShowAdapter(
    private val clickListener: (TvShowPresentation) -> Unit
): RecyclerView.Adapter<TvShowAdapter.ImageViewHolder>() {

    /** Properties **/
    var data = mutableListOf<TvShowPresentation>()

    /** ViewHolder functions **/
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

    /** Inner Class **/
    inner class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        /** Properties of Inner class **/
        private val binding = ItemListBinding.bind(itemView)
        private lateinit var item: TvShowPresentation

        init {
            binding.image.setOnClickListener {
                clickListener(item)
            }
        }

        fun bind (item:TvShowPresentation) {
            this.item = item
            with (binding) {
                imageTitle.text = item.name
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/${item.posterPath}")
                    .placeholder(ContextCompat.getDrawable(itemView.context, R.mipmap.ic_launcher))
                    .into(image)

                votedRating.text = "%.2f".format(item.voted)
                println("Oliver -> TvShowAdapter -> ${item.favorited}")
                if (item.favorited == false) {
                    favButton.background = ContextCompat.getDrawable(itemView.context,
                        R.drawable.ic_launcher_foreground
                    )
                } else {
                    favButton.background = ContextCompat.getDrawable(itemView.context, R.drawable.ic_baseline_white_24)
                }

                }
            }

    }
}

