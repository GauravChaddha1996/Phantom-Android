package com.project.phantom.ui.snippets.stepper

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButton
import com.project.phantom.ui.button.PhantomButtonType

@Composable
fun StepperSnippet(data: StepperSnippetData, onClick: () -> Unit = {}) {
    PhantomButton(
        data = ButtonData(
            text = data.title?.setDefaults(
                textStyle = PhantomTextStyle.TitleSemiLarge
            ),
            type = PhantomButtonType.SOLID
        ),
        contentPadding = PaddingValues(PaddingStyle.large, PaddingStyle.medium),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = PaddingStyle.large,
                end = PaddingStyle.large,
                top = PaddingStyle.large,
                bottom = PaddingStyle.nano
            ),
        onClick = onClick
    )
}
