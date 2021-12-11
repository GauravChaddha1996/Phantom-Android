package com.project.phantom.ui.grid

import androidx.compose.runtime.Composable
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.snippets.productDual.ProductDualSnippet
import com.project.phantom.ui.snippets.productDual.ProductDualSnippetData

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
