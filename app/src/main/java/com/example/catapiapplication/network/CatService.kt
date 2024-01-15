package com.example.catapiapplication.network

import com.example.catapi.CatBreeds
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("breeds")
    suspend fun breeds(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
    ): List<CatBreeds>
}