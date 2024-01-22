package com.example.catapiapplication.network

import com.example.catapi.CatBreeds
import com.example.catapi.ImageData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface CatService {
    companion object {
        const val API_KEY = "live_lLRkGxJcDnLUTe1mB7dZzwxlpvHPMCc0gbjHS2FZBCJNBMIdkN9rmOhms3NzcbI6"
    }

    @GET("breeds")
    suspend fun breeds(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
    ): List<CatBreeds>

    @Headers("x-api-key: $API_KEY")
    @GET("images/{image_id}")
    suspend fun images(
        @Path("image_id") imageId: String
    ) : ImageData
}