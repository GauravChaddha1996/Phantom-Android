package com.project.phantom.ui.snippets.textSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.ui.text.PhantomText

@Composable
fun TextSnippet(data: TextSnippetData) {
    Column {
        PhantomText(
            data = data.title,
            modifier = Modifier.padding(data.titlePaddingValues)
        )
        PhantomText(
            data = data.subtitle,
            modifier = Modifier
                .padding(data.subtitlePaddingValues)
                .alpha(ContentAlpha.medium)
        )
        PhantomText(
            data = data.subtitle2,
            modifier = Modifier.padding(data.subtitle2PaddingValues)
        )
        if (data.bottomSeparator == true) {
            Box(
                modifier = Modifier.padding(
                    start = PaddingStyle.large,
                    end = PaddingStyle.large,
                    top = PaddingStyle.large
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.45.dp)
                        .background(AppThemeColors.onBackground)
                        .alpha(ContentAlpha.disabled)
                )
            }
        }
    }
}
