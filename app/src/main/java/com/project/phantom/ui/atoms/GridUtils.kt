package com.project.phantom.ui.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.data.snippets.ProductDualSnippetData
import com.project.phantom.data.snippets.base.SnippetData
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.snippets.ProductDualSnippet

@Composable
internal fun HandleGridSnippetData(
    snippetDataList: List<SnippetData?>,
    modifier: Modifier,
    interaction: SnippetInteractions
) {
    snippetDataList.forEach { snippetData ->
        snippetData ?: return@forEach
        when (snippetData) {
            is ProductDualSnippetData -> {
                ProductDualSnippet(
                    data = snippetData,
                    modifier = modifier,
                    interaction = interaction
                )
            }
        }
    }
}