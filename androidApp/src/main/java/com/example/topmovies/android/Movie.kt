package com.example.topmovies.android

import android.app.Application
import com.example.topmovies.android.di.appModule
import com.example.topmovies.di.getSharedModules
import org.koin.core.context.startKoin

class Movie: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}