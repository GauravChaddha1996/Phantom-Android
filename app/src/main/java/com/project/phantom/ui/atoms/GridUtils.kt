package com.project.phantom.ui.atoms

import androidx.compose.runtime.Composable
import com.project.phantom.data.snippets.ProductDualSnippetData
import com.project.phantom.data.snippets.base.SnippetData
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.snippets.ProductDualSnippet

@Composable
internal fun HandleGridSnippetData(
    snippetData: SnippetData,
    interaction: SnippetInteractions
) {
    when (snippetData) {
        is ProductDualSnippetData -> {
            ProductDualSnippet(data = snippetData, interaction = interaction)
        }
    }
}