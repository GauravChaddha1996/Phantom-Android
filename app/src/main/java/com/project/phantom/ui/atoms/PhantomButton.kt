package com.project.phantom.ui.atoms

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.project.phantom.data.atoms.PhantomButtonData
import com.project.phantom.data.atoms.PhantomButtonType
import com.project.phantom.theme.PhantomTheme

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
            PhantomTheme.colors.primary
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