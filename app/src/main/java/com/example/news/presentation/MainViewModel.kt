package com.example.news.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.NewsData
//import com.example.domain.model.NewsData
//import com.example.domain.model.Post
import com.example.domain.usecase.GetNewsUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val getNewsUseCase: GetNewsUseCase): ViewModel() {

    var myCustomPosts = MutableLiveData<List<NewsData>>()

   fun getCustomPosts() {
       viewModelScope.launch {
           val response = getNewsUseCase.getCustomPost()
           myCustomPosts.value = response.data
       }
   }

}