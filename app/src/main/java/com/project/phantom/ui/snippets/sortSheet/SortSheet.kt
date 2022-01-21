package com.project.phantom.ui.snippets.sortSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.project.phantom.screens.category.models.SortSheetData
import com.project.phantom.screens.category.models.getSelectedSortMethod

@Composable
fun SortSheet(sortSheetData: SortSheetData?) {
    sortSheetData?.methods?.isNullOrEmpty() ?: return
    var selectedSortMethod by remember {
        mutableStateOf(sortSheetData.getSelectedSortMethod())
    }
    Column {
        sortSheetData.methods.forEach { sortMethodData ->
            SortMethodSnippet(
                data = sortMethodData,
                isSelected = sortMethodData.id == selectedSortMethod?.id,
                onClick = {
                    if (sortMethodData.id != selectedSortMethod?.id) {
                        selectedSortMethod?.selected = false
                        sortMethodData.selected = true
                        selectedSortMethod = sortMethodData
                    }
                }
            )
        }
    }
}
