package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.data.snippets.base.SnippetData
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.snippets.ProductRailSnippet

@Composable
fun HorizontalList(rvDataState: State<List<SnippetData>?>) {
    LazyRow(content = {
        rvDataState.value?.forEach {
            when (it) {
                is ProductRailSnippetData -> {
                    item {
                        ProductRailSnippet(
                            data = it,
                            interaction = SnippetInteractions()
                        )
                    }
                }
            }
        }
    }, contentPadding = PaddingValues(12.dp))
}