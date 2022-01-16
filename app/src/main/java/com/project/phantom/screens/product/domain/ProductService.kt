package com.project.phantom.screens.product.domain

import com.project.phantom.screens.product.models.ProductResponseData
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ProductService {
    @GET("product")
    suspend fun getProductPage(@QueryMap map: Map<String, String>): ProductResponseData
}
