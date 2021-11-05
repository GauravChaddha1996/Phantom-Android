package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.ui.grid.GridData
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.grid.HandleGridSnippetData

@Composable
fun PhantomGrid(gridDataState: State<GridData>, interaction: SnippetInteractions) {
    val gridData = gridDataState.value
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