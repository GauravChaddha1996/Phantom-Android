package com.project.phantom.ui.snippets.productRail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.Utils
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.ElevationStyle
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImage
import com.project.phantom.ui.list.HorizontalList
import com.project.phantom.ui.list.HorizontalListData
import com.project.phantom.ui.text.MarkdownConfig
import com.project.phantom.ui.text.MarkdownFontSpan
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Composable
fun ProductRailSnippet(data: ProductRailSnippetData?, interaction: ProductRailSnippetInteraction) {
    data ?: return

    Card(
        modifier = Modifier
            .width(
                Utils
                    .getScreenWidth()
                    .times(0.75f)
            ),
        elevation = ElevationStyle.medium,
        shape = CornerStyle.large
    ) {
        Column(
            modifier = Modifier.clickable {
                interaction.onProductRailSnippetClicked(data)
            }
        ) {
            PhantomImage(
                data = data.imageData,
                modifier = Modifier.aspectRatio(1.83f)
            )
            Row(
                modifier = Modifier.padding(PaddingStyle.large),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f, true)
                        .padding(end = PaddingStyle.large),
                    verticalArrangement = Arrangement.spacedBy(PaddingStyle.small)
                ) {
                    PhantomText(data = data.name)
                    PhantomText(data = data.shortDesc)
                    PhantomText(data = data.brandAndCategory)
                }
                PhantomText(data = data.cost)
            }
        }
    }
}

interface ProductRailSnippetInteraction {
    fun onProductRailSnippetClicked(data: ProductRailSnippetData?)
}

@Preview
@Composable
private fun TestProductRailSnippet() {
    val data = ProductRailSnippetData.create(
        ProductRailSnippetApiData(
            id = 1,
            name = TextData("Solid black shirt"),
            shortDesc = TextData("Soft cotton shirt made by well paid work"),
            brandAndCategory = TextData(
                "by Adidas in Shirts",
                markdownConfig = MarkdownConfig(
                    true,
                    listOf(
                        MarkdownFontSpan(PhantomFontStyle.SEMIBOLD_400, 3, 9),
                        MarkdownFontSpan(PhantomFontStyle.SEMIBOLD_400, 13, 19)
                    )
                )
            ),
            cost = TextData("$200"),
            imageData = ImageData("url")
        )
    )
    Surface {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            HorizontalList(
                rvDataState = mutableStateOf(
                    HorizontalListData(
                        listOf(data, data)
                    )
                ),
                interaction = SnippetInteractions()
            )
        }
    }
}
