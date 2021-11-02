package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.project.phantom.data.snippets.base.SnippetData
import com.project.phantom.screens.base.SnippetInteractions


@Composable
fun VerticalList(rvDataState: State<List<SnippetData>?>, interaction: SnippetInteractions) {
    LazyColumn(
        content = {
            val list = rvDataState.value
            list?.forEach { handleSnippetData(it, interaction) }
        },
        verticalArrangement = Arrangement.SpaceAround
    )
}