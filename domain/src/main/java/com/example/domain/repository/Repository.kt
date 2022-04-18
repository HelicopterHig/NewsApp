package com.example.domain.repository


import com.example.domain.model.NewsList


interface Repository {
   suspend fun getCustomPosts(): NewsList
}