package com.project.phantom.screens.base

import com.project.phantom.Utils.isNotNullOrEmpty
import com.project.phantom.data.snippets.ProductFullSnippetApiData
import com.project.phantom.data.snippets.ProductFullSnippetData
import com.project.phantom.data.snippets.ProductRailSnippetApiData
import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.data.snippets.base.*
import org.koin.core.component.KoinComponent

class BaseSnippetCurator : KoinComponent {
    fun curate(snippetSectionList: List<SnippetSectionData>?): MutableList<SnippetData> {
        val finalList = mutableListOf<SnippetData>()

        // For each snippet section
        snippetSectionList?.forEach { snippetSection ->
            // Add the section header
            val headerSnippets = curateHeaderData(snippetSection.headerData)
            finalList.addAll(headerSnippets)

            // Add the section actual stuff
            val snippetsList = curateSnippetData(snippetSection.snippetApiList)
            if (snippetsList.isNotNullOrEmpty()) {
                finalList.addAll(snippetsList)
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

    private fun curateSnippetData(apiSnippets: List<SnippetApiData>?): List<SnippetData> {
        val finalList = mutableListOf<SnippetData>()
        apiSnippets?.forEach { apiSnippet ->
            val snippetData: SnippetData? = when (apiSnippet) {
                is ProductRailSnippetApiData -> ProductRailSnippetData.create(apiSnippet)
                is ProductFullSnippetApiData -> ProductFullSnippetData.create(apiSnippet)
                else -> null
            }
            snippetData ?: return@forEach
            finalList.add(snippetData)
        }
        return finalList
    }
}