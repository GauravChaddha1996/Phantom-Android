package com.project.phantom.screens.product.domain

import androidx.compose.foundation.layout.PaddingValues
import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.theme.PaddingStyle.huge
import com.project.phantom.theme.PaddingStyle.large
import com.project.phantom.theme.PaddingStyle.small
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.snippets.commons.SnippetSectionData
import com.project.phantom.ui.snippets.sectionHeader.SectionHeaderSnippetData
import com.project.phantom.ui.snippets.textSection.TextSectionSnippetData

class ProductPageCurator : BaseSnippetCurator() {

    @Suppress("NestedBlockDepth")
    override fun curate(snippetSectionList: List<SnippetSectionData>?): MutableList<SnippetData> {
        val results = super.curate(snippetSectionList)
        results.forEach {
            when (it) {
                is SectionHeaderSnippetData -> {
                    it.paddingValues =
                        PaddingValues(start = large, top = huge)
                }
                is TextSectionSnippetData -> {
                    curateTextSection(it)
                }
            }
        }
        return results
    }

    private fun curateTextSection(it: TextSectionSnippetData) {
        it.textSectionArr?.forEach { textSnippet ->
            textSnippet.subtitle2?.let {
                textSnippet.titlePaddingValues = PaddingValues(large, large, huge, small)
            }
        }
    }
}
