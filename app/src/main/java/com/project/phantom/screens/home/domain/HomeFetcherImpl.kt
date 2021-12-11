package com.project.phantom.screens.home.domain

import com.project.phantom.screens.home.models.HomeResponseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeFetcherImpl(private val service: HomeService) : HomeFetcher {
    override suspend fun fetchHomePage(): HomeResponseData = withContext(Dispatchers.IO) {
        service.getHomePage()
    }
}
