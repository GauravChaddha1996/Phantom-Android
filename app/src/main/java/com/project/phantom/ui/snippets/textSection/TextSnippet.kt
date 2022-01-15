package com.project.phantom.ui.snippets.textSection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.theme.PaddingStyle.large
import com.project.phantom.theme.PaddingStyle.small
import com.project.phantom.ui.text.PhantomText

@Composable
fun TextSnippet(data: TextSectionSnippetData.TextSnippet) {
    Column {
        PhantomText(
            data = data.title,
            modifier = Modifier.padding(start = large, end = large, top = large, bottom = small)
        )
    }
    PhantomText(
        data = data.subtitle,
        modifier = Modifier.padding(start = large, end = large, top = small, bottom = large)
    )
}
