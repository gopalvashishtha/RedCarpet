package com.example.redcarpet.Adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.redcarpet.model.Article1
import com.example.redcarpet.GlideApp
import com.example.redcarpet.GlideApp.init
import com.example.redcarpet.Headlines_fragmentDirections
import com.example.redcarpet.R
import kotlinx.android.synthetic.main.news_item.view.*


class adapter:RecyclerView.Adapter<adapter.NewsViewHolder>() {
    private var news:List<Article1> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int {
       return news.size
    }
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = news[position]
        holder.bind(article)
    }
    fun setNews(news:List<Article1>){
        this.news = news
        notifyDataSetChanged()

    }
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(article: Article1){
            itemView.apply {
                GlideApp.with(ImageView)
                    .load(article.urlToImage)
                    .into(ImageView)

                itemView.Title.text = article.title

                if (article.publishedAt != null) {
                    var date: TextView= time1
                    date.text = article.publishedAt ?: "Unknown"
                }
                if(article.author != null) {
                    itemView.Host.text = article.author
                }
                else if(article.source1.name != null){
                    itemView.Host.text = article.source1.name
                }
                else{
                    itemView.Host.text = "unknown"
                }
             //   itemView.card.

                    itemView.setOnClickListener {
                        findNavController().navigate(
                            Headlines_fragmentDirections.actionHeadlinesFragmentToDetailnewsFragment(
                                article.title!!,
                                article.author!!,
                                article.content1!!,
                                article.source1.name!!,
                                article.urlToImage!!,
                                article.url!!,
                                article.publishedAt!!,
                                article.description!!,
                                "unknown"
                            )
                        )
                    }

            }
        }
        companion object{
            fun from(parent: ViewGroup): NewsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val itemView = inflater.inflate(R.layout.news_item,parent,false)
                return NewsViewHolder(
                    itemView
                )
            }
        }
    }
}