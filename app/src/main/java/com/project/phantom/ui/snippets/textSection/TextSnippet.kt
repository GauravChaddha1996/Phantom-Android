package com.project.phantom.ui.snippets.textSection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.ui.text.PhantomText

@Composable
fun TextSnippet(data: TextSectionSnippetData.TextSnippet) {
    Column {
        PhantomText(
            data = data.title,
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 4.dp)
        )
    }
    PhantomText(
        data = data.subtitle,
        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 12.dp)
    )
}
