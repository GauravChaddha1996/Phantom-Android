package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.project.phantom.data.snippets.base.GridData
import com.project.phantom.screens.base.SnippetInteractions

@Composable
fun PhantomGrid(gridDataState: State<GridData>, interaction: SnippetInteractions) {
    val gridData = gridDataState.value
    val gridList = gridData.list
    val numberOfColumns = gridData.noOfColumns

    Row {
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