package com.project.phantom.screens.home.domain

import com.project.phantom.screens.home.view.HomeScreenState

interface HomeViewModel {
    val state: HomeScreenState
    fun loadPage()
    fun refreshPage()
}