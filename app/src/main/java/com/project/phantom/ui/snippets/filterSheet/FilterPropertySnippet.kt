package com.project.phantom.ui.snippets.filterSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.models.FilterPropertySection
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.list.HorizontalList
import com.project.phantom.ui.list.HorizontalListData
import com.project.phantom.ui.text.PhantomText

@Composable
fun FilterPropertySnippet(
    propertySection: FilterPropertySection,
    interactions: SnippetInteractions
) {
    if (propertySection.pills.isNullOrEmpty()) return
    val finalHorizontalPillsList = remember {
        propertySection.pills.windowed(size = 4, step = 4, partialWindows = true) {
            HorizontalListData(it.toList())
        }
    }
    Column {
        PhantomText(
            data = propertySection.name,
            modifier = Modifier.padding(
                start = PaddingStyle.large,
                end = PaddingStyle.large,
                top = PaddingStyle.nano,
                bottom = PaddingStyle.large
            )
        )
        finalHorizontalPillsList.forEach {
            HorizontalList(
                modifier = Modifier
                    .padding(bottom = PaddingStyle.large),
                rvData = it,
                interaction = interactions
            )
        }
    }
}
