package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.data.snippets.base.GridData
import com.project.phantom.screens.base.SnippetInteractions

@Composable
fun PhantomGrid(gridDataState: State<GridData>, interaction: SnippetInteractions) {
    val data = gridDataState.value
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        HandleGridSnippetData(
            snippetDataList = data.list,
            interaction = interaction,
            modifier = Modifier.weight(1f)
        )
    }
}