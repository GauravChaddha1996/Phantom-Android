package com.project.phantom.screens.home.domain

import com.project.phantom.screens.home.models.HomeResponseData

interface HomeFetcher {
    suspend fun fetchHomePage(): HomeResponseData
}
