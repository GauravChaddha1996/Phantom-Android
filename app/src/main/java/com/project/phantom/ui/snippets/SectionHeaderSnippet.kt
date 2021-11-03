package com.project.phantom.ui.snippets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.data.atoms.*
import com.project.phantom.data.snippets.base.SectionHeaderSnippetData
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.atoms.PhantomButton
import com.project.phantom.ui.atoms.PhantomText

@Composable
fun SectionHeaderSnippet(
    data: SectionHeaderSnippetData?,
    interaction: SectionHeaderSnippetInteraction
) {
    Row {
        Column(Modifier.weight(1f)) {
            PhantomText(data = data?.title)
            PhantomText(data = data?.subtitle)
        }
        PhantomButton(data = data?.rightButton,
            onClick = {
                interaction.onSectionHeaderSnippetRightButtonClicked(data)
            })
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
                    title = PhantomTextData.create(TextData("Section title")),
                    subtitle = PhantomTextData.create(TextData("Section subtitle")),
                    rightButton = PhantomButtonData.create(
                        ButtonData(
                            TextData("Button"),
                            PhantomButtonType.TEXT
                        )
                    )
                ), interaction = SnippetInteractions()
            )
        }
    }
}