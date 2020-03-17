package com.example.newshomework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newshomework.R
import com.example.newshomework.model.Article
import com.example.newshomework.model.News
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter (var newsList:ArrayList<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
    inner class NewsViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){

        fun bindNews(articles :Article){
            itemView.tvContent.text=articles.content
            itemView.tvTitle.text=articles.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindNews(newsList[position])
    }
}