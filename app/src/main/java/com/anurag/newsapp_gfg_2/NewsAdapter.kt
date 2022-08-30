package com.anurag.newsapp_gfg_2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val list: List<Article>,private val context:Context): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>()  {

    class NewsViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val newsImage: ImageView = itemview.findViewById(R.id.news_image)
        val titleText: TextView = itemview.findViewById(R.id.title_text)
        val descTextView: TextView= itemview.findViewById(R.id.desc_text)
        val subtitle:TextView = itemview.findViewById(R.id.subtitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.new_item,parent, false)
        return NewsViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.titleText.text = list[position].title
        holder.descTextView.text = list[position].description
        holder.subtitle.text = list[position].title
        Glide.with(context)
            .load(list[position].urlToImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.newsImage)

        val currentItem = list[position]

        holder.itemView.setOnClickListener{
            val intent  = Intent(context, ArticleActivity::class.java)
            // you can do using intent.putExtras also
//            intent.putExtra("image", currentItem.urlToImage)
//            intent.putExtra("title", currentItem.title)
//            intent.putExtra("author", currentItem.author)
//            intent.putExtra("desc", currentItem.description)

            val bundle = bundleOf("image" to currentItem.urlToImage,
                "title" to currentItem.title,
                "author" to currentItem.author,
                "desc" to currentItem.description,
                "url" to currentItem.url)
            intent.putExtras(bundle)
            context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}