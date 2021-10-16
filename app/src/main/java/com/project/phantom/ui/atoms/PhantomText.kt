package com.project.phantom.ui.atoms

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import com.project.phantom.data.uiModels.atoms.PhantomTextData
import com.project.phantom.data.uiModels.merge

@Composable
fun PhantomText(
    data: PhantomTextData?,
    modifiers: List<Modifier>? = null,
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
        modifier = modifiers.merge(),
        color = data.color.resolvedColor,
        textAlign = textAlign,
        style = data.font.resolvedTextStyle
    )
}