package com.project.phantom.screens.category.domain

import com.project.phantom.screens.category.models.CategoryResponseData
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.screens.category.view.CategoryPageInitModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryFetcherImpl(private val service: CategoryService) : CategoryFetcher {

    companion object {
        private const val KEY_CATEGORY_ID = "category_id"
        private const val KEY_SORT_ID = "sort_id"
    }

    override suspend fun fetchCategoryPage(
        initModel: CategoryPageInitModel,
        sortMethodData: SortMethodData?
    ): CategoryResponseData = withContext(Dispatchers.IO) {
        val map = hashMapOf<String, String>()
        map[KEY_CATEGORY_ID] = initModel.categoryId.toString()
        sortMethodData?.id?.let {
            map[KEY_SORT_ID] = it.toString()
        }
        return@withContext service.getCategoryPage(map)
    }
}
