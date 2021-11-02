package com.project.phantom.screens.base

import com.project.phantom.Utils.isNotNullOrEmpty
import com.project.phantom.data.snippets.ProductFullSnippetData
import com.project.phantom.data.snippets.ProductFullSnippetNetworkData
import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.data.snippets.ProductRailSnippetNetworkData
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
            val snippetsList = curateSnippetData(snippetSection.snippetNetworkList)
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

    private fun curateSnippetData(networkSnippets: List<SnippetNetworkData>?): List<SnippetData> {
        val finalList = mutableListOf<SnippetData>()
        networkSnippets?.forEach { networkData ->
            val snippetData: SnippetData? = when (networkData) {
                is ProductRailSnippetNetworkData -> ProductRailSnippetData.create(networkData)
                is ProductFullSnippetNetworkData -> ProductFullSnippetData.create(networkData)
                else -> null
            }
            snippetData ?: return@forEach
            finalList.add(snippetData)
        }
        return finalList
    }
}