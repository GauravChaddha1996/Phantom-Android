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
        private const val KEY_PROPERTY_VALUE_IDS = "property_value_ids"
    }

    override suspend fun fetchCategoryPage(
        initModel: CategoryPageInitModel,
        selectedSortMethodData: SortMethodData?,
        selectedPropertyValueSet: Set<Int>
    ): CategoryResponseData = withContext(Dispatchers.IO) {
        val map = hashMapOf<String, String>()
        map[KEY_CATEGORY_ID] = initModel.categoryId.toString()
        selectedSortMethodData?.id?.let {
            map[KEY_SORT_ID] = it.toString()
        }
        selectedPropertyValueSet.takeIf { it.isNotEmpty() }?.toIntArray()?.let {
            map[KEY_PROPERTY_VALUE_IDS] = it.toList().toString()
        }
        return@withContext service.getCategoryPage(map)
    }
}
