package com.project.phantom.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.snippets.commons.SnippetData

@Composable
fun VerticalList(
    rvDataState: List<SnippetData>?,
    interaction: SnippetInteractions,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(vertical = PaddingStyle.large),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(PaddingStyle.huge)
) {
    LazyColumn(
        content = {
            rvDataState?.forEach { handleListSnippetData(it, interaction) }
        },
        verticalArrangement = verticalArrangement,
        contentPadding = contentPadding,
        modifier = modifier
    )
}
