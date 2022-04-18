package com.example.news

import android.app.Application
import com.example.news.di.AppComponent
import com.example.news.di.AppModule
import com.example.news.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}