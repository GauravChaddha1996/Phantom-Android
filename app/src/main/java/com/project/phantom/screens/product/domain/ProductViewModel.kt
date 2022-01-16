package com.project.phantom.screens.product.domain

import com.project.phantom.screens.base.BaseViewModel
import com.project.phantom.screens.product.ui.ProductScreenState

abstract class ProductViewModel : BaseViewModel() {
    abstract val state: ProductScreenState
    abstract fun loadPage()
}
