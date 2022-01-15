package com.project.phantom.ui.snippets.filterProperty

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.models.FilterPropertyUiSection
import com.project.phantom.theme.PaddingStyle.large
import com.project.phantom.ui.list.HorizontalList
import com.project.phantom.ui.list.HorizontalListData
import com.project.phantom.ui.text.PhantomText

@Composable
fun FilterPropertySnippet(
    propertySection: FilterPropertyUiSection,
    interactions: SnippetInteractions
) {
    Column {
        PhantomText(data = propertySection.name, modifier = Modifier.padding(large))
        propertySection.propertyValues?.let {
            HorizontalList(rvData = HorizontalListData(it), interaction = interactions)
        }
    }
}
