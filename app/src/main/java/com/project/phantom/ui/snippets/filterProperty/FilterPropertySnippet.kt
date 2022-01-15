package com.project.phantom.ui.snippets.filterProperty

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.models.FilterPropertyUiSection
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.project.phantom.ui.list.HorizontalList
import com.project.phantom.ui.list.HorizontalListData
import com.project.phantom.ui.text.PhantomText

@Composable
fun FilterPropertySnippet(
    propertySection: FilterPropertyUiSection,
    showSeparator: Boolean,
    interactions: SnippetInteractions
) {
    Column {
        PhantomText(data = propertySection.name, modifier = Modifier.padding(12.dp))
        propertySection.propertyValues?.let {
            HorizontalList(rvData = HorizontalListData(it), interaction = interactions)
        }
        if (showSeparator) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                    .alpha(ContentAlpha.medium)
                    .background(PhantomColors.resolve(PhantomColorName.GREY_100))
            )
        }
    }
}
