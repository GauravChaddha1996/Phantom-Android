package com.project.phantom.ui.snippets.productRail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.R
import com.project.phantom.getScreenWidth
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle.BodyMedium
import com.project.phantom.theme.PhantomFontStyle.LabelLarge
import com.project.phantom.theme3.AppThemeColors
import com.project.phantom.ui.card.OutlinedCard
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImage
import com.project.phantom.ui.list.HorizontalList
import com.project.phantom.ui.list.HorizontalListData
import com.project.phantom.ui.text.MarkdownConfig
import com.project.phantom.ui.text.MarkdownFontSpan
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Composable
fun ProductRailSnippet(
    data: ProductRailSnippetData?,
    interaction: ProductRailSnippetInteraction
) {
    data ?: return

    OutlinedCard(
        modifier = Modifier.width(getScreenWidth(times = 0.75f))
    ) {
        Column(
            modifier = Modifier.clickable {
                interaction.onProductRailSnippetClicked(data)
            }
        ) {
            Box {
                PhantomImage(
                    data = data.imageData,
                    modifier = Modifier.aspectRatio(ratio = 1.83f),
                    contentScale = ContentScale.None
                )
                Box(
                    modifier = Modifier
                        .padding(PaddingStyle.medium)
                        .align(Alignment.TopEnd)
                        .clip(
                            RoundedCornerShape(
                                topStart = CornerSize(0.dp),
                                topEnd = CornerSize(PaddingStyle.medium),
                                bottomStart = CornerSize(PaddingStyle.medium),
                                bottomEnd = CornerSize(0.dp)
                            )
                        )
                        .background(AppThemeColors.primary)
                ) {
                    PhantomText(
                        data = TextData().setDefaults(
                            defaultText = stringResource(id = R.string.new3),
                            fontStyle = LabelLarge,
                            colorName = PhantomColorName.OnPrimary
                        ),
                        modifier = Modifier.padding(
                            horizontal = PaddingStyle.medium,
                            vertical = PaddingStyle.small
                        )
                    )
                }
            }
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
                    PhantomText(
                        data = data.shortDesc,
                        modifier = Modifier.alpha(ContentAlpha.medium)
                    )
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
    val data = ProductRailSnippetData(
        id = 1,
        name = TextData("Solid black shirt"),
        shortDesc = TextData("Soft cotton shirt made by well paid work"),
        brandAndCategory = TextData(
            "by Adidas in Shirts",
            markdownConfig = MarkdownConfig(
                true,
                listOf(
                    MarkdownFontSpan(BodyMedium, start = 3, end = 9),
                    MarkdownFontSpan(BodyMedium, start = 13, end = 19)
                )
            )
        ),
        cost = TextData("$200"),
        imageData = ImageData("url")
    )
    data.setDefaults()

    Surface {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            HorizontalList(
                HorizontalListData(
                    listOf(data, data)
                ),
                interaction = SnippetInteractions()
            )
        }
    }
}
