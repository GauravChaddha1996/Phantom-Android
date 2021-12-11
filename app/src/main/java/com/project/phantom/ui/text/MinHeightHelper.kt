package com.project.phantom.ui.text

import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.resolveDefaults
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.ceil
import kotlin.math.roundToInt

internal fun minLinesHeight(
    minLines: Int,
    textStyle: TextStyle,
    density: Density,
    resourceLoader: Font.ResourceLoader,
    layoutDirection: LayoutDirection
): Int {
    if (minLines == 0) return 0
    val twoLines = EmptyTextReplacement + "\n" + EmptyTextReplacement

    // Difference between the height of two lines paragraph and one line paragraph gives us
    // an approximation of height of one line
    val firstLineHeight = computeSizeForDefaultText(
        style = resolveDefaults(textStyle, layoutDirection),
        density = density,
        resourceLoader = resourceLoader,
        text = EmptyTextReplacement,
        maxLines = 1
    ).height
    val firstTwoLinesHeight = computeSizeForDefaultText(
        style = resolveDefaults(textStyle, layoutDirection),
        density = density,
        resourceLoader = resourceLoader,
        text = twoLines,
        maxLines = 2
    ).height

    val lineHeightWithSpacing = firstTwoLinesHeight - firstLineHeight
    return firstLineHeight + lineHeightWithSpacing * (minLines - 1)
}

internal fun computeSizeForDefaultText(
    style: TextStyle,
    density: Density,
    resourceLoader: Font.ResourceLoader,
    text: String,
    maxLines: Int = 1
): IntSize {
    val paragraph = Paragraph(
        text = text,
        style = style,
        spanStyles = listOf(),
        maxLines = maxLines,
        ellipsis = false,
        density = density,
        resourceLoader = resourceLoader,
        width = Float.POSITIVE_INFINITY
    )
    return IntSize(paragraph.minIntrinsicWidth.toIntPx(), paragraph.height.toIntPx())
}

private fun Float.toIntPx(): Int = ceil(this).roundToInt()
