package com.project.phantom.ui.snippets.filterSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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
        HorizontalList(
            modifier = Modifier.padding(bottom = PaddingStyle.large),
            rvData = HorizontalListData(propertySection.pills),
            interaction = interactions
        )
    }
}
