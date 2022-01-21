package com.project.phantom.ui.snippets.filterSheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.models.FilterSheetData
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.list.VerticalList

@Composable
fun FilterSheet(filterSheetData: FilterSheetData?, interactions: SnippetInteractions) {
    filterSheetData ?: return
    VerticalList(
        rvDataState = filterSheetData.propertySections ?: emptyList(),
        verticalArrangement = Arrangement.spacedBy(PaddingStyle.small),
        contentPadding = PaddingValues(0.dp),
        interaction = interactions
    )
}
