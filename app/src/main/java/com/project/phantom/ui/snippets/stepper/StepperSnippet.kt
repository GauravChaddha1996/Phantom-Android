package com.project.phantom.ui.snippets.stepper

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButton
import com.project.phantom.ui.button.PhantomButtonType

@Composable
fun StepperSnippet(data: StepperSnippetData) {
    PhantomButton(
        data = ButtonData(
            text = data.title?.setDefaults(
                fontStyle = PhantomFontStyle.MEDIUM_700
            ),
            type = PhantomButtonType.SOLID
        ),
        contentPadding = PaddingValues(PaddingStyle.large, PaddingStyle.medium),
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingStyle.large)
    )
}
