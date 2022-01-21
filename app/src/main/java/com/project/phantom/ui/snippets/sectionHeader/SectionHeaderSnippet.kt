package com.project.phantom.ui.snippets.sectionHeader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButton
import com.project.phantom.ui.button.PhantomButtonType
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Composable
fun SectionHeaderSnippet(
    data: SectionHeaderSnippetData?,
    interaction: SectionHeaderSnippetInteraction
) {
    Row(
        modifier = Modifier.padding(
            data?.paddingValues ?: PaddingValues(start = PaddingStyle.large)
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PhantomText(
            data = data?.title,
            modifier = Modifier.weight(1f)
        )
        PhantomButton(
            data = data?.rightButton,
            onClick = { interaction.onSectionHeaderSnippetRightButtonClicked(data) },
            showArrowIcon = true
        )
    }
}

interface SectionHeaderSnippetInteraction {
    fun onSectionHeaderSnippetRightButtonClicked(data: SectionHeaderSnippetData?)
}

@Preview
@Composable
fun TestSectionHeaderSnippet() {
    Surface {
        Box(Modifier.fillMaxWidth(1f)) {
            SectionHeaderSnippet(
                data = SectionHeaderSnippetData(
                    title = TextData("Section title"),
                    rightButton = ButtonData(
                        TextData("Button"),
                        PhantomButtonType.TEXT
                    )
                ).apply { setDefaults() },
                interaction = SnippetInteractions()
            )
        }
    }
}
