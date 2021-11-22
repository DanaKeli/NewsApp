package com.example.newsapp.adapters

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.data.News
import com.example.newsapp.databinding.NewsItemBinding

class NewsViewHolder(
    private val binding: NewsItemBinding,
    private val onItemClick: (item: LinearLayout) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) {
        binding.ivImage.apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            load(news.image) {
                size(80, 80)
            }
        }
        binding.tvDescription.text = news.title
        binding.newsItemLayout.setOnClickListener {
            onItemClick(binding.newsItemLayout)
        }
    }
}