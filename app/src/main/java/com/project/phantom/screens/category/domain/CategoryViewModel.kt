package com.project.phantom.screens.category.domain

import com.project.phantom.screens.base.BaseViewModel
import com.project.phantom.screens.category.view.CategoryScreenState

abstract class CategoryViewModel : BaseViewModel() {
    abstract val state: CategoryScreenState
    abstract fun loadPage()
    abstract fun onApplyClicked()
    abstract fun onFilterClearClicked()
}
