package com.project.phantom.screens.home.domain

import com.project.phantom.screens.base.BaseViewModel
import com.project.phantom.screens.home.view.HomeScreenState

abstract class HomeViewModel : BaseViewModel() {
    abstract val state: HomeScreenState
    abstract fun loadPage()
    abstract fun refreshPage()
}