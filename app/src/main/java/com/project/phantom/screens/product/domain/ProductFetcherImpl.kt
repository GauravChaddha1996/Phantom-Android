package com.project.phantom.screens.product.domain

import com.project.phantom.screens.product.models.ProductResponseData
import com.project.phantom.screens.product.ui.ProductPageInitModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductFetcherImpl(val service: ProductService) : ProductFetcher {
    companion object {
        private const val KEY_PRODUCT_ID = "product_id"
    }

    override suspend fun fetchProductPage(initModel: ProductPageInitModel): ProductResponseData =
        withContext(Dispatchers.IO) {
            val queryMap = hashMapOf<String, String>()
            queryMap[KEY_PRODUCT_ID] = initModel.productId.toString()
            return@withContext service.getProductPage(queryMap)
        }
}
