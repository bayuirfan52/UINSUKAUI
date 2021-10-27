package com.example.uinsukaui.ui.home.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uinsukaui.data.model.News
import com.example.uinsukaui.databinding.ItemNewsBinding

class NewsAdapter(private val context: Context, private val list: List<News>) : RecyclerView.Adapter<NewsAdapter.NewsVH>() {

    inner class NewsVH(val view: ItemNewsBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH =
        NewsVH(ItemNewsBinding.inflate(LayoutInflater.from(context), parent, false))

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        val item = list[position]
        holder.view.apply {
            Glide.with(context)
                .load(item.image)
                .into(imgHeadline)

            txtHeadline.text = item.headline
            txtDate.text = item.date
        }
    }

    override fun getItemCount(): Int = list.size
}