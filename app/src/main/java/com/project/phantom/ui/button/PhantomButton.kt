package com.project.phantom.ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.PhantomColorName.RED_500
import com.project.phantom.theme.PhantomColorName.WHITE
import com.project.phantom.theme.resolve
import com.project.phantom.ui.text.PhantomText

@Composable
fun PhantomButton(
    data: ButtonData?,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit = {}
) {
    // Cases to check for visibility
    if (data == null || data.text?.text.isNullOrEmpty()) {
        return
    }

    val colors = when (data.type) {
        PhantomButtonType.TEXT -> ButtonDefaults.buttonColors(
            Color.Transparent,
            RED_500.resolve()
        )
        PhantomButtonType.SOLID -> ButtonDefaults.buttonColors(
            RED_500.resolve(),
            WHITE.resolve()
        )
        else -> ButtonDefaults.buttonColors()
    }

    val textDecoration = when (data.type) {
        PhantomButtonType.TEXT -> TextDecoration.Underline
        else -> null
    }

    // Add the button
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier,
        colors = colors,
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp),
        contentPadding = contentPadding
    ) {
        PhantomText(data = data.text, textDecoration = textDecoration)
    }
}
