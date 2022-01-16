package com.project.phantom.screens.product.domain

import com.project.phantom.screens.product.models.ProductResponseData
import com.project.phantom.screens.product.ui.ProductPageInitModel

interface ProductFetcher {
    suspend fun fetchProductPage(
        initModel: ProductPageInitModel
    ): ProductResponseData
}
