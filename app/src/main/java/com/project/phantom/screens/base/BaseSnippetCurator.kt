package com.project.phantom.screens.base

import com.project.phantom.Utils.isNotNullOrEmpty
import com.project.phantom.ui.grid.GridData
import com.project.phantom.ui.list.HorizontalListData
import com.project.phantom.ui.snippets.categoryRail.CategoryRailSnippetData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.snippets.commons.SnippetSectionData
import com.project.phantom.ui.snippets.productDual.ProductDualSnippetData
import com.project.phantom.ui.snippets.productRail.ProductRailSnippetData
import org.koin.core.component.KoinComponent

class BaseSnippetCurator : KoinComponent {
    fun curate(snippetSectionList: List<SnippetSectionData>?): MutableList<SnippetData> {
        val finalList = mutableListOf<SnippetData>()

        // For each snippet section
        snippetSectionList?.forEach { snippetSection ->
            // Add the section header
            snippetSection.headerData?.let {
                it.setDefaults()
                finalList.add(it)
            }

            // Add the section actual stuff
            val snippetsList = curateSectionSnippetList(snippetSection.snippetList)
            if (snippetsList.isNotNullOrEmpty()) {
                finalList.addAll(snippetsList)
            }
        }

        return finalList
    }

    private fun curateSectionSnippetList(sectionSnippetList: List<SnippetData>?): List<SnippetData> {
        val curatedSnippets = mutableListOf<SnippetData>()

        // Flags to help curate
        var isHorizontalRail = false
        var isGrid = false
        var gridNumberOfColumns = 1

        // Set flags when iterating the section snippet list
        sectionSnippetList?.forEach { snippetData ->
            snippetData.setDefaults()
            when (snippetData) {
                is ProductRailSnippetData -> {
                    isHorizontalRail = true
                }
                is CategoryRailSnippetData -> {
                    isHorizontalRail = true
                }
                is ProductDualSnippetData -> {
                    isGrid = true
                    gridNumberOfColumns = 2
                }
            }
            curatedSnippets.add(snippetData)
        }

        // Use the flags to return correct section snippet data list
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
