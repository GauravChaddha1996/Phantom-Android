package com.project.phantom.screens.product.domain

import androidx.compose.foundation.layout.PaddingValues
import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.snippets.commons.SnippetSectionData
import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippetData
import com.project.phantom.ui.snippets.textSection.TextSnippetData

class ProductPageCurator : BaseSnippetCurator() {

    @Suppress("NestedBlockDepth")
    override fun curate(snippetSectionList: List<SnippetSectionData>?): MutableList<SnippetData> {
        val results = super.curate(snippetSectionList)
        results.forEach {
            when (it) {
                is SectionHeaderSnippetData -> {
                    it.paddingValues =
                        PaddingValues(start = PaddingStyle.large, top = PaddingStyle.huge)
                }
                is TextSnippetData -> {
                    curateTextSection(it)
                }
            }
        }
        return results
    }

    private fun curateTextSection(textSnippetData: TextSnippetData) {
        textSnippetData.subtitle2?.let {
            val titlePadding = PaddingValues(
                PaddingStyle.large,
                PaddingStyle.large,
                PaddingStyle.huge,
                PaddingStyle.small
            )
            textSnippetData.titlePaddingValues = titlePadding
        }
    }
}
