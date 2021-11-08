package com.project.phantom.ui.text

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFontLoader
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

internal const val DefaultWidthCharCount = 10 // min width for TextField is 10 chars long
internal val EmptyTextReplacement = "H".repeat(DefaultWidthCharCount) // just a reference character.

@Composable
fun PhantomText(
    data: PhantomTextData?,
    modifier: Modifier = Modifier,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null
) {

    // Cases to check for visibility
    if (data == null || data.text.isEmpty()) {
        return
    }

    // minLines height logic
    val density = LocalDensity.current
    val resourceLoader = LocalFontLoader.current
    val layoutDirection = LocalLayoutDirection.current
    val minLineHeight = remember(data, density, resourceLoader, layoutDirection) {
        minLinesHeight(
            minLines = data.minLines,
            textStyle = data.font.resolvedTextStyle,
            density = density,
            resourceLoader = resourceLoader,
            layoutDirection = layoutDirection
        )
    }

    // Add the final text
    Text(
        text = data.text,
        modifier = modifier
            .heightIn(min = with(LocalDensity.current) {
                minLineHeight.toDp()
            }),
        color = data.color.resolvedColor,
        style = data.font.resolvedTextStyle,
        textDecoration = textDecoration,
        textAlign = textAlign,
        maxLines = data.maxLines,
        overflow = data.overflow
    )
}