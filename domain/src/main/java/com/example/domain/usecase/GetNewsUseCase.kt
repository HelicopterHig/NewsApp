package com.example.domain.usecase


import com.example.domain.model.NewsList
import com.example.domain.repository.Repository


class GetNewsUseCase(val repository: Repository) {

   suspend fun getCustomPost(): NewsList {
        return repository.getCustomPosts()
   }
}