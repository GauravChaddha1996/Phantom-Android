package com.project.phantom.ui.button

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.PhantomColorName.RED_500
import com.project.phantom.theme.PhantomColors
import com.project.phantom.ui.text.PhantomText

@Composable
fun PhantomButton(
    data: PhantomButtonData?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    // Cases to check for visibility
    if (data == null || data.text.text.isEmpty()) {
        return
    }

    val colors = when (data.type) {
        PhantomButtonType.TEXT -> ButtonDefaults.buttonColors(
            Color.Transparent,
            PhantomColors.resolve(RED_500)
        )
    }

    val textDecoration = when (data.type) {
        PhantomButtonType.TEXT -> TextDecoration.Underline
    }

    // Add the button
    Button(
        onClick = {
            onClick.invoke()
        },
        modifier = modifier,
        colors = colors,
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp)
    ) {
        PhantomText(data = data.text, textDecoration = textDecoration)
    }
}