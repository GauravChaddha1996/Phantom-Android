package com.project.phantom.screens.base

import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.data.snippets.ProductRailSnippetNetworkData
import com.project.phantom.data.snippets.base.SnippetData
import com.project.phantom.data.snippets.base.SnippetSectionData
import com.project.phantom.data.snippets.base.SnippetSectionHeaderData

class BaseSnippetCurator {
    fun curate(snippets: List<SnippetSectionData>?): MutableList<SnippetData> {
        val finalList = mutableListOf<SnippetData>()

        snippets?.forEach {
            val headerSnippets = curateHeaderData(it.headerData)
            finalList.addAll(headerSnippets)

            it.snippets?.forEach {
                when (it) {
                    is ProductRailSnippetNetworkData -> {
                        finalList.add(ProductRailSnippetData.create(it))
                    }
                }
            }
        }

        return finalList
    }

    private fun curateHeaderData(headerData: SnippetSectionHeaderData?): List<SnippetData> {
        val headerSnippets = mutableListOf<SnippetData>()
        headerData?.let {

        }
        return headerSnippets
    }
}