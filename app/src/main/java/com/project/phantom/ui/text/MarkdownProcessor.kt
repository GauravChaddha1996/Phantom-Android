package com.project.phantom.ui.text

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import com.project.phantom.theme.resolve

object MarkdownProcessor {

    fun processTextData(textData: TextData?): AnnotatedString {
        val spans = mutableListOf<AnnotatedString.Range<SpanStyle>>()

        textData?.markdownConfig?.takeIf { it.enabled == true }?.spans?.forEach {
            val span = when (it) {
                is MarkdownFontSpan -> processFontSpan(it)
                else -> null
            }
            span ?: return@forEach
            spans.add(span)
        }
        return AnnotatedString(textData?.text ?: "", spans)
    }

    private fun processFontSpan(it: MarkdownFontSpan): AnnotatedString.Range<SpanStyle> {
        val textStyle = it.style.resolve()
        return AnnotatedString.Range(
            SpanStyle(
                fontSize = textStyle.fontSize,
                fontWeight = textStyle.fontWeight,
                fontStyle = textStyle.fontStyle,
                fontFamily = textStyle.fontFamily
            ),
            it.start,
            it.end
        )
    }
}
