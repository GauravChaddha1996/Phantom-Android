package com.project.phantom.screens.category.domain

import com.project.phantom.screens.category.models.CategoryResponseData
import com.project.phantom.screens.category.view.CategoryPageInitModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryFetcherImpl(private val service: CategoryService) : CategoryFetcher {

    companion object {
        private const val KEY_CATEGORY_ID = "category_id"
    }

    override suspend fun fetchCategoryPage(initModel: CategoryPageInitModel): CategoryResponseData =
        withContext(Dispatchers.IO) {
            val map = hashMapOf<String, String>()
            map[KEY_CATEGORY_ID] = initModel.categoryId.toString()
            return@withContext service.getCategoryPage(map)
        }
}
