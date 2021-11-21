package com.project.phantom.ui.snippets.productDual

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.ElevationStyle
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.grid.GridData
import com.project.phantom.ui.grid.PhantomGrid
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImage
import com.project.phantom.ui.text.MarkdownConfig
import com.project.phantom.ui.text.MarkdownFontSpan
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Composable
fun ProductDualSnippet(
    data: ProductDualSnippetData?,
    modifier: Modifier = Modifier,
    interaction: ProductDualSnippetInteraction
) {
    data ?: return
    Card(
        elevation = ElevationStyle.medium,
        shape = CornerStyle.large
    ) {
        Column(
            modifier = Modifier.clickable {
                interaction.onProductDualSnippetClicked(data)
            },
        ) {
            PhantomImage(
                data = data.imageData,
                modifier = Modifier.aspectRatio(1.05f)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(PaddingStyle.small),
                modifier = Modifier.padding(vertical = PaddingStyle.large)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = PaddingStyle.large),
                    verticalAlignment = Alignment.Top
                ) {
                    PhantomText(
                        data = data.name,
                        modifier = Modifier
                            .weight(1f, true)
                            .padding(end = PaddingStyle.small)
                    )
                    PhantomText(data = data.cost)
                }
                Column(
                    modifier = Modifier.padding(horizontal = PaddingStyle.large),
                    verticalArrangement = Arrangement.spacedBy(PaddingStyle.small)
                ) {

                    PhantomText(data = data.shortDesc)
                    PhantomText(data = data.brand)
                }
            }
        }
    }

}

interface ProductDualSnippetInteraction {
    fun onProductDualSnippetClicked(data: ProductDualSnippetData?)
}

@Preview
@Composable
private fun TestProductDualSnippet() {
    val data = ProductDualSnippetData.create(
        ProductDualSnippetApiData(
            1,
            name = TextData("Solid black shirt"),
            shortDesc = TextData(
                "Soft cotton shirt made by good workers"
            ),
            brand = TextData(
                "by Adidas",
                markdownConfig = MarkdownConfig(
                    true,
                    listOf(MarkdownFontSpan(PhantomFontStyle.MEDIUM_200, 3, 9))
                )
            ),
            cost = TextData("$200"),
            imageData = ImageData("url")
        )
    )
    Surface {
        PhantomGrid(
            mutableStateOf(
                GridData(2, listOf(data, data))
            ),
            interaction = SnippetInteractions()
        )
    }
}