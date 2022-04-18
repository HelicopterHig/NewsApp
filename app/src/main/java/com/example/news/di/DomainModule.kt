package com.example.news.di

import com.example.domain.repository.Repository
import com.example.domain.usecase.GetNewsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideNewsUseCase(repository: Repository): GetNewsUseCase{
        return  GetNewsUseCase(repository)
    }
}