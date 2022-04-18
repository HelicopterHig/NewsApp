package com.example.news.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.GetNewsUseCase

class MainViewModelFactory(private  val getNewsUseCase: GetNewsUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getNewsUseCase) as T
    }
}