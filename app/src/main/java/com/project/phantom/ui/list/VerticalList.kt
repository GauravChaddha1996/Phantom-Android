package com.project.phantom.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.snippets.commons.SnippetData


@Composable
fun VerticalList(rvDataState: State<List<SnippetData>?>, interaction: SnippetInteractions) {
    LazyColumn(
        content = {
            val list = rvDataState.value
            list?.forEach { handleListSnippetData(it, interaction) }
        },
        verticalArrangement = Arrangement.spacedBy(PaddingStyle.huge),
        contentPadding = PaddingValues(vertical = PaddingStyle.large)
    )
}