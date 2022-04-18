package com.example.news.di

import android.content.Context
import com.example.domain.usecase.GetNewsUseCase
import com.example.news.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideNewsViewModelFactory(getNewsUseCase: GetNewsUseCase): MainViewModelFactory{
        return MainViewModelFactory(getNewsUseCase)
    }



}