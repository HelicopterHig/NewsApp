package com.example.news.adapter


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.NewsData
import com.example.news.R
import com.example.news.databinding.NewsItemBinding


class NewsAdapter(private val mContext: Activity): RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    private var myList = emptyList<NewsData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder( NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myList[position])

        holder.itemView.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse( myList[position].url.toString()))
            Log.d("URL",myList[position].url.toString() )
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    inner class ViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(newsData: NewsData ) {
            binding.tvAuthor.text = newsData.author.toString()
            binding.tvContent.text = newsData.content.toString()
            binding.tvDate.text = newsData.date.toString()
            binding.tvTime.text = newsData.time.toString()
            binding.tvTitle.text = newsData.title.toString()

            setNewsImage(newsData)
        }

        private fun setNewsImage(newsData: NewsData ) {
            Glide.with(itemView)
                .load(newsData.imageUrl)
                .placeholder(R.drawable.imgdef)
                .into(binding.newsImg)
        }
    }

    fun setData(newList: List<NewsData?> ){
        try {
            myList = newList as List<NewsData>
            notifyDataSetChanged()
        }catch (e: Exception){
            Log.d("Exeption", "Data not changed")
        }
    }

}