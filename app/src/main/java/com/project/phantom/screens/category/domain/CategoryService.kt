package com.project.phantom.screens.category.domain

import com.project.phantom.screens.category.models.CategoryResponseData
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CategoryService {
    @GET("filter")
    suspend fun getCategoryPage(@QueryMap map: Map<String, String>): CategoryResponseData
}
