package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.project.phantom.data.snippets.base.SnippetData


@Composable
fun VerticalList(rvDataState: State<List<SnippetData>?>) {
    LazyColumn(
        content = {
            val list = rvDataState.value
            list?.forEach { handleSnippetData(it) }
        },
        verticalArrangement = Arrangement.SpaceAround
    )
}