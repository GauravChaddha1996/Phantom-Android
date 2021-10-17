package com.project.phantom.ui.atoms

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.project.phantom.data.atoms.PhantomTextData

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

    // Make the final text to be shown
    val isMarkdownEnabled = data.markdownConfig?.enabled == true
    var finalText = AnnotatedString(data.text)
    if (isMarkdownEnabled) {
        finalText = buildAnnotatedString {
            append(finalText)
        }
    }

    // Add the final text
    Text(
        text = finalText,
        modifier = modifier,
        color = data.color.resolvedColor,
        style = data.font.resolvedTextStyle,
        textDecoration = textDecoration,
        textAlign = textAlign
    )
}