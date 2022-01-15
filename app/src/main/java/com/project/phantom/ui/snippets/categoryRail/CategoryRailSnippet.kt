package com.project.phantom.ui.snippets.categoryRail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.ElevationStyle
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomColorName.YELLOW_100
import com.project.phantom.theme.PhantomColorName.YELLOW_400
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.getResolvedColor
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Composable
fun CategoryRailSnippet(
    data: CategoryRailSnippetData?,
    interaction: CategoryRailSnippetInteraction
) {
    data ?: return
    Card(
        modifier = Modifier.size(200.dp, 200.dp),
        shape = CornerStyle.large,
        elevation = ElevationStyle.large
    ) {
        Box(
            modifier = Modifier
                .clickable { interaction.onCategoryRailSnippetClicked(data) }
                .background(data.bgColor.getResolvedColor())
        ) {
            PhantomText(
                data = data.firstCharacter,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .alpha(alpha = 0.25f)
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
                    firstCharacter = TextData("S", color = ColorData(YELLOW_400)),
                    name = TextData("Shirts"),
                    bgColor = ColorData(YELLOW_100)
                ),
                interaction = SnippetInteractions()
            )
        }
    }
}
