package com.project.phantom.ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.text.PhantomText

@Composable
fun PhantomButton(
    data: ButtonData?,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues? = null,
    onClick: () -> Unit = {}
) {
    // Cases to check for visibility
    if (data == null || data.text?.text.isNullOrEmpty()) {
        return
    }

    when (data.type) {
        PhantomButtonType.SOLID -> GetSolidButton(data, modifier, contentPadding, onClick)
        PhantomButtonType.TEXT, null -> GetTextButton(data, modifier, contentPadding, onClick)
    }
}

@Composable
private fun GetTextButton(
    data: ButtonData,
    modifier: Modifier,
    contentPadding: PaddingValues?,
    onClick: () -> Unit
) {
    TextButton(
        onClick = { onClick.invoke() },
        modifier = modifier,
        colors = ButtonDefaults.textButtonColors(),
        contentPadding = contentPadding ?: ButtonDefaults.TextButtonContentPadding
    ) {
        PhantomText(data = data.text)
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            modifier = Modifier
                .size(LocalTextStyle.current.fontSize.value.dp)
                .padding(start = PaddingStyle.nano)
                .offset(y = 1.dp)
        )
    }
}

@Composable
private fun GetSolidButton(
    data: ButtonData,
    modifier: Modifier,
    contentPadding: PaddingValues?,
    onClick: () -> Unit
) {
    FilledTonalButton(
        onClick = { onClick.invoke() },
        modifier = modifier,
        colors = ButtonDefaults.filledTonalButtonColors(),
        contentPadding = contentPadding ?: ButtonDefaults.ContentPadding
    ) {
        PhantomText(data = data.text)
    }
}
