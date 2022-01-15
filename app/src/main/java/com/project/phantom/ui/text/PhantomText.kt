package com.project.phantom.ui.text

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFontLoader
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.project.phantom.ui.commons.getResolvedColor

internal const val DefaultWidthCharCount = 10 // min width for TextField is 10 chars long
internal val EmptyTextReplacement = "H".repeat(DefaultWidthCharCount) // just a reference character.

@Composable
fun PhantomText(
    data: TextData?,
    modifier: Modifier = Modifier,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    autoSize: Boolean = false,
    color: Color? = null
) {
    // Cases to check for visibility
    if (data == null || data.text.isNullOrEmpty()) {
        return
    }

    val processedText = MarkdownProcessor.processTextData(data)
    var finalModifier = modifier
    var readyToDraw by remember { mutableStateOf(false) }
    var finalTextStyle by remember { mutableStateOf(data.font.resolvedTextStyle) }

    // minLines height logic
    val density = LocalDensity.current
    val resourceLoader = LocalFontLoader.current
    val layoutDirection = LocalLayoutDirection.current
    val minLineHeight = remember(data, density, resourceLoader, layoutDirection) {
        minLinesHeight(
            minLines = data.minLines ?: 0,
            textStyle = finalTextStyle,
            density = density,
            resourceLoader = resourceLoader,
            layoutDirection = layoutDirection
        )
    }

    // autosize handling
    if (autoSize) {
        finalModifier = finalModifier.drawWithContent {
            if (readyToDraw) {
                drawContent()
            }
        }
    }

    // Add the final text
    Text(
        text = processedText,
        modifier = finalModifier
            .heightIn(
                min = with(LocalDensity.current) {
                    minLineHeight.toDp()
                }
            ),
        color = color ?: data.color.getResolvedColor(),
        style = finalTextStyle,
        textDecoration = textDecoration,
        textAlign = textAlign,
        maxLines = data.maxLines ?: Int.MAX_VALUE,
        overflow = data.overflow,
        softWrap = !autoSize,
        onTextLayout = {
            if (autoSize) {
                if (it.didOverflowWidth) {
                    finalTextStyle =
                        finalTextStyle.copy(fontSize = finalTextStyle.fontSize.times(other = 0.9))
                } else {
                    readyToDraw = true
                }
            }
        }
    )
}
