package com.project.phantom.screens.cart.domain

import com.project.phantom.screens.base.BaseViewModel
import com.project.phantom.screens.cart.view.CartScreenState

abstract class CartViewModel : BaseViewModel() {
    abstract val state: CartScreenState

    abstract fun loadCart()
    abstract fun addItem(productId: Int)
    abstract fun removeItem(productId: Int)
}
