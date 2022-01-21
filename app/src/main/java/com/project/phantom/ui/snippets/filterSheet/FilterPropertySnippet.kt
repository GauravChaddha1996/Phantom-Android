package com.project.phantom.ui.snippets.filterProperty

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.models.FilterPropertySection
import com.project.phantom.theme.PaddingStyle.large
import com.project.phantom.theme.PaddingStyle.medium
import com.project.phantom.theme.PaddingStyle.nano
import com.project.phantom.ui.list.HorizontalList
import com.project.phantom.ui.list.HorizontalListData
import com.project.phantom.ui.text.PhantomText

@Composable
fun FilterPropertySnippet(
    propertySection: FilterPropertySection,
    interactions: SnippetInteractions
) {
    if (propertySection.pills.isNullOrEmpty()) return
    Column {
        PhantomText(
            data = propertySection.name,
            modifier = Modifier.padding(
                start = large,
                end = large,
                top = nano,
                bottom = medium
            )
        )
        HorizontalList(
            rvData = HorizontalListData(propertySection.pills),
            interaction = interactions,
            modifier = Modifier.padding(bottom = large)
        )
    }
}
