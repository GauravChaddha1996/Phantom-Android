package com.project.phantom.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions

@Composable
fun HorizontalList(rvDataState: State<HorizontalListData>, interaction: SnippetInteractions) {
    LazyRow(
        content = {
            val list = rvDataState.value.list
            list.forEach { handleListSnippetData(it, interaction) }
        },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 12.dp)
    )
}