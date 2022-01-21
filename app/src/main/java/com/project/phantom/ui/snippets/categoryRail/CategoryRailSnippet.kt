package com.project.phantom.ui.snippets.categoryRail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.AppThemeColors
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.PhantomColor.OnSurfaceVariant
import com.project.phantom.theme.color.PhantomColor.Surface
import com.project.phantom.ui.card.FilledCard
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Composable
fun CategoryRailSnippet(
    data: CategoryRailSnippetData?,
    interaction: CategoryRailSnippetInteraction
) {
    data ?: return
    FilledCard(
        modifier = Modifier.size(200.dp, 200.dp)
    ) {
        Box(
            modifier = Modifier
                .clickable { interaction.onCategoryRailSnippetClicked(data) }
                .background(AppThemeColors.secondary.copy(alpha = 0.01f))
        ) {
            PhantomText(
                data = data.firstCharacter,
                modifier = Modifier
                    .align(Alignment.Center)
                    .scale(scale = 1.3f)
                    .alpha(alpha = 0.45f),
                textAlign = TextAlign.Center
            )
            PhantomText(
                data = data.name,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(PaddingStyle.large),
                autoSize = true
            )
        }
    }
}

interface CategoryRailSnippetInteraction {
    fun onCategoryRailSnippetClicked(data: CategoryRailSnippetData?)
}

@Preview
@Composable
private fun TestCategoryRailSnippet() {
    Surface {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            CategoryRailSnippet(
                data = CategoryRailSnippetData(
                    id = 1,
                    firstCharacter = TextData("S", color = ColorData(OnSurfaceVariant)),
                    name = TextData("Shirts"),
                    bgColor = ColorData(Surface)
                ).apply { setDefaults() },
                interaction = SnippetInteractions()
            )
        }
    }
}
