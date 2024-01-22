package com.example.catapiapplication.data

import com.example.catapiapplication.network.CatService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val catRepository: CatRepository
}

class DefaultAppContainer : AppContainer {
    private val baseURL = "https://api.thecatapi.com/v1/"

    private val retrofit: Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseURL)
            .build()

    private val retrofitService: CatService by lazy {
        retrofit.create(CatService::class.java)
    }

    override val catRepository: CatRepository by lazy {
        NetworkCatRepository(retrofitService)
    }
}