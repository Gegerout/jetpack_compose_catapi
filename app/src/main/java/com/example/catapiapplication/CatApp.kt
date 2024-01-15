package com.example.catapiapplication

import android.app.Application
import com.example.catapiapplication.data.AppContainer
import com.example.catapiapplication.data.DefaultAppContainer

class CatApp : Application() {
    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}