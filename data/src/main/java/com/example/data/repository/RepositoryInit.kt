package com.example.data.repository

import com.example.data.api.Api
import com.example.domain.model.NewsData
import com.example.domain.model.NewsList
//import com.example.domain.model.Post
import com.example.domain.repository.Repository
import retrofit2.Response

class RepositoryInit( val api: Api): Repository {

   override suspend fun getCustomPosts(): NewsList {
        return  api.getCustomPosts()
   }
}