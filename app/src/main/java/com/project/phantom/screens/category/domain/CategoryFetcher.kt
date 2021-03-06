package com.project.phantom.screens.category.domain

import com.project.phantom.screens.category.models.CategoryResponseData
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.screens.category.view.CategoryPageInitModel

interface CategoryFetcher {
    suspend fun fetchCategoryPage(
        initModel: CategoryPageInitModel,
        selectedSortMethodData: SortMethodData?,
        selectedFilters: Set<Int>
    ): CategoryResponseData
}
