package com.project.phantom.screens.home.domain

import com.project.phantom.screens.home.models.HomeResponseData
import retrofit2.http.GET

interface HomeService {
    @GET("/home")
    suspend fun getHomePage(): HomeResponseData
}