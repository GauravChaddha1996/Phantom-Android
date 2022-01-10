package com.project.phantom.screens.category.view

import com.project.phantom.screens.category.models.FilterSheetData
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.screens.category.models.SortSheetData
import com.project.phantom.ui.lce.PhantomLceData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData

data class CategoryScreenState(
    val lceState: PhantomLceData = PhantomLceData.getLoadingData(),
    val pageTitle: TextData? = null,
    val frontLayerHeader: TextData? = null,
    val rvDataState: List<SnippetData> = emptyList(),
    val sortSheetData: SortSheetData? = null,
    val selectedSortMethodData: SortMethodData? = null,
    val filterSheetData: FilterSheetData? = null,
    val selectedPropertyValueIds: Set<Int> = emptySet()
)
