package com.example.data.api

import com.example.domain.model.NewsData
import com.example.domain.model.NewsList
import retrofit2.Response


import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/news?category=science")
    suspend fun getCustomPosts(): NewsList
}