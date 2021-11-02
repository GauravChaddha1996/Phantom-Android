package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.project.phantom.data.snippets.base.HorizontalListData

@Composable
fun HorizontalList(rvDataState: State<HorizontalListData>) {
    LazyRow(
        content = {
            val list = rvDataState.value.list
            list.forEach { handleSnippetData(it) }
        },
        contentPadding = PaddingValues(12.dp)
    )
}