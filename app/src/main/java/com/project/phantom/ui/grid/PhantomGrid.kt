package com.project.phantom.ui.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle.large

@Composable
fun PhantomGrid(gridData: GridData, interaction: SnippetInteractions) {
    val gridList = gridData.list
    val numberOfColumns = gridData.noOfColumns

    Row(
        horizontalArrangement = Arrangement.spacedBy(large),
        modifier = Modifier.padding(horizontal = large)
    ) {
        for (index in 0 until numberOfColumns) {
            val snippet = gridList.getOrNull(index)
            if (snippet == null) {
                Spacer(modifier = Modifier.weight(1f, fill = true))
            } else {
                Box(Modifier.weight(1f, true), propagateMinConstraints = true) {
                    HandleGridSnippetData(
                        snippetData = snippet,
                        interaction = interaction
                    )
                }
            }
        }
    }
}
