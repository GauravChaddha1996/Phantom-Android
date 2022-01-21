package com.project.phantom.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle

@Composable
fun HorizontalList(
    modifier: Modifier = Modifier,
    rvData: HorizontalListData,
    interaction: SnippetInteractions,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(PaddingStyle.large),
    contentPadding: PaddingValues = PaddingValues(horizontal = PaddingStyle.large)
) {
    LazyRow(
        content = {
            val list = rvData.list
            list.forEach { handleListSnippetData(it, interaction) }
        },
        horizontalArrangement = horizontalArrangement,
        contentPadding = contentPadding,
        modifier = modifier
    )
}
