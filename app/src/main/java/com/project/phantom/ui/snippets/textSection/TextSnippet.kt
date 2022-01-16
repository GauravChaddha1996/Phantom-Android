package com.project.phantom.ui.snippets.textSection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.ui.text.PhantomText

@Composable
fun TextSnippet(data: TextSectionSnippetData.TextSnippet) {
    Column {
        PhantomText(
            data = data.title,
            modifier = Modifier.padding(data.titlePaddingValues)
        )
        PhantomText(
            data = data.subtitle,
            modifier = Modifier.padding(data.subtitlePaddingValues)
        )
        PhantomText(
            data = data.subtitle2,
            modifier = Modifier.padding(data.subtitle2PaddingValues)
        )
    }
}
