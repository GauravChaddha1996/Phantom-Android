package com.project.phantom.screens.base

import com.project.phantom.Utils.isNotNullOrEmpty
import com.project.phantom.data.snippets.*
import com.project.phantom.data.snippets.base.*
import org.koin.core.component.KoinComponent

class BaseSnippetCurator : KoinComponent {
    fun curate(snippetSectionList: List<SnippetSectionData>?): MutableList<SnippetData> {
        val finalList = mutableListOf<SnippetData>()

        // For each snippet section
        snippetSectionList?.forEach { snippetSection ->
            // Add the section header
            val headerSnippets = curateHeaderData(snippetSection.headerApiData)
            finalList.addAll(headerSnippets)

            // Add the section actual stuff
            val snippetsList = curateSnippetData(snippetSection.snippetApiList)
            if (snippetsList.isNotNullOrEmpty()) {
                finalList.addAll(snippetsList)
            }
        }

        return finalList
    }


    private fun curateHeaderData(headerApiData: SnippetSectionHeaderApiData?): List<SnippetData> {
        val headerSnippets = mutableListOf<SnippetData>()
        headerApiData?.let {
            headerSnippets.add(SectionHeaderSnippetData.create(it))
        }
        return headerSnippets
    }

    private fun curateSnippetData(apiSnippets: List<SnippetApiData>?): List<SnippetData> {
        val curatedSnippets = mutableListOf<SnippetData>()

        var isHorizontalRail = false
        var isGrid = false
        var gridNumberOfColumns = 1

        apiSnippets?.forEach { apiSnippet ->
            val snippetData: SnippetData? = when (apiSnippet) {
                is ProductRailSnippetApiData -> {
                    isHorizontalRail = true
                    ProductRailSnippetData.create(apiSnippet)
                }
                is CategoryRailSnippetApiData -> {
                    isHorizontalRail = true
                    CategoryRailSnippetData.create(apiSnippet)
                }
                is ProductFullSnippetApiData -> {
                    ProductFullSnippetData.create(apiSnippet)
                }
                is ProductDualSnippetApiData -> {
                    isGrid = true
                    gridNumberOfColumns = 2
                    ProductDualSnippetData.create(apiSnippet)
                }
                else -> null
            }
            snippetData ?: return@forEach
            curatedSnippets.add(snippetData)
        }

        return when {
            isHorizontalRail -> {
                listOf(HorizontalListData(curatedSnippets))
            }
            isGrid -> {
                val gridList = mutableListOf<GridData>()
                curatedSnippets.windowed(gridNumberOfColumns, gridNumberOfColumns, true) {
                    gridList.add(GridData(gridNumberOfColumns, it.toList()))
                }
                gridList
            }
            else -> {
                curatedSnippets
            }
        }
    }
}