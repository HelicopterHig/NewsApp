package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.domain.model.NewsData
//import com.example.domain.model.NewsData
//import com.example.domain.model.Post
import com.example.news.presentation.MainViewModel
import com.example.news.adapter.NewsAdapter
import com.example.news.databinding.ActivityMainBinding
import com.example.news.presentation.MainViewModelFactory

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel
    private val newsAdapter by lazy { NewsAdapter(mContext = this) }


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerview()

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.getCustomPosts()
        viewModel.myCustomPosts.observe(this, Observer { response ->
            newsAdapter.setData(response)
        })
    }

   private fun setupRecyclerview() {
       binding.rcView.adapter = newsAdapter
       binding.rcView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
   }
}