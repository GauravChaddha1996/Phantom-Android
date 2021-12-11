package com.project.phantom.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle

@Composable
fun HorizontalList(rvData: HorizontalListData, interaction: SnippetInteractions) {
    LazyRow(
        content = {
            val list = rvData.list
            list.forEach { handleListSnippetData(it, interaction) }
        },
        horizontalArrangement = Arrangement.spacedBy(PaddingStyle.large),
        contentPadding = PaddingValues(horizontal = PaddingStyle.large)
    )
}
