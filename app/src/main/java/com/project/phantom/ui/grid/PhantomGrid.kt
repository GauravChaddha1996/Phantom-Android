package com.project.phantom.ui.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions

@Composable
fun PhantomGrid(gridData: GridData, interaction: SnippetInteractions) {
    val gridList = gridData.list
    val numberOfColumns = gridData.noOfColumns

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(horizontal = 12.dp)
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
