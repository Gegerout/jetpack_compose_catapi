package com.example.catapiapplication.data

import com.example.catapiapplication.network.CatService

interface CatRepository {
    suspend fun getBreeds(limit: Int, page: Int): List<Breeds>
}

class NetworkCatRepository(
    private val catService: CatService
) : CatRepository {
    override suspend fun getBreeds(limit: Int, page: Int): List<Breeds> =
        catService.breeds(limit, page)
            .map { item ->
                Breeds(
                    name = item.name,
                    description = item.description,
                    image = item.referenceImageId?.let { catService.images(it).url }
                )
            }
}