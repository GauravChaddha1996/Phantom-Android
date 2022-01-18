package com.project.phantom.ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import com.project.phantom.theme3.AppThemeColors
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
            AppThemeColors.primary
        )
        PhantomButtonType.SOLID -> ButtonDefaults.buttonColors(
            AppThemeColors.primary,
            AppThemeColors.onPrimary
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
        elevation = ButtonDefaults.filledTonalButtonElevation(),
        contentPadding = contentPadding
    ) {
        PhantomText(data = data.text, textDecoration = textDecoration)
    }
}
