package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.project.phantom.data.snippets.base.HorizontalListData
import com.project.phantom.screens.base.SnippetInteractions

@Composable
fun HorizontalList(rvDataState: State<HorizontalListData>, interaction: SnippetInteractions) {
    LazyRow(
        content = {
            val list = rvDataState.value.list
            list.forEach { handleSnippetData(it, interaction) }
        },
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    )
}