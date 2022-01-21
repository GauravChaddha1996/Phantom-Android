package com.project.phantom.screens.home.domain

import com.project.phantom.logger.PhantomLogger
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.home.models.HomeResponseData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class HomeRepo(
    private val homeFetcher: HomeFetcher
) {
    private val coroutineScope = CoroutineScope(
        Dispatchers.IO +
            PhantomCEH { PhantomLogger.logException(it) }
    )
    private var homeResponseFetchJob: Job? = null
    var homeResponse: HomeResponseData? = null

    fun fetch() {
        // Start a home response fetch job
        homeResponseFetchJob = coroutineScope.launch {
            // Cache the response
            homeResponse = homeFetcher.fetchHomePage()
        }
        // Cancel the scope once the job is complete
        homeResponseFetchJob?.invokeOnCompletion {
            coroutineScope.cancel()
        }
    }

    suspend fun waitForResponse(): HomeResponseData? {
        // If job is already completed (with or without exception), return whatever cache we have
        if (homeResponseFetchJob?.isCompleted == true) {
            return homeResponse
        }
        // Otherwise wait for the job to complete, and then return our cached response
        homeResponseFetchJob?.join()
        return homeResponse
    }
}
