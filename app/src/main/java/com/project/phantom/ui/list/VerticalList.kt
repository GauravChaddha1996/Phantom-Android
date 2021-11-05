package com.project.phantom.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.screens.base.SnippetInteractions


@Composable
fun VerticalList(rvDataState: State<List<SnippetData>?>, interaction: SnippetInteractions) {
    LazyColumn(
        content = {
            val list = rvDataState.value
            list?.forEach { handleListSnippetData(it, interaction) }
        },
        verticalArrangement = Arrangement.spacedBy(20.dp)
    )
}