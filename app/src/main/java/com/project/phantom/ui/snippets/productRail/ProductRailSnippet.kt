package com.project.phantom.ui.snippets.productRail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
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
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.getScreenWidth
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.ui.card.OutlinedCard
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImage
import com.project.phantom.ui.list.HorizontalList
import com.project.phantom.ui.list.HorizontalListData
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
                GetImage(data.imageData)
                GetNewTag(data.newTag)
            }
            GetTextSection(data)
        }
    }
}

@Composable
private fun GetImage(imageData: ImageData?) {
    PhantomImage(
        data = imageData,
        modifier = Modifier.aspectRatio(ratio = 1.2f),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
    )
}

@Composable
private fun BoxScope.GetNewTag(newTag: TextData?) {
    Box(
        modifier = Modifier
            .padding(PaddingStyle.medium)
            .align(Alignment.TopEnd)
            .clip(
                RoundedCornerShape(
                    topStart = CornerSize(PaddingStyle.zero),
                    topEnd = CornerSize(PaddingStyle.medium),
                    bottomStart = CornerSize(PaddingStyle.medium),
                    bottomEnd = CornerSize(PaddingStyle.zero)
                )
            )
            .background(AppThemeColors.primary)
    ) {
        PhantomText(
            data = newTag,
            modifier = Modifier.padding(
                horizontal = PaddingStyle.medium,
                vertical = PaddingStyle.small
            )
        )
    }
}

@Composable
private fun GetTextSection(data: ProductRailSnippetData) {
    Column(
        modifier = Modifier.padding(PaddingStyle.large),
        verticalArrangement = Arrangement.spacedBy(PaddingStyle.small)
    ) {
        Row {
            PhantomText(data = data.name, modifier = Modifier.weight(1f))
            PhantomText(data = data.cost, modifier = Modifier.padding(start = PaddingStyle.medium))
        }
        PhantomText(
            data = data.shortDesc,
            modifier = Modifier.alpha(ContentAlpha.medium)
        )
        PhantomText(data = data.brandAndCategory)
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
        brandAndCategory = TextData("By Adidas In Shirts"),
        cost = TextData("$200"),
        imageData = ImageData("url")
    )
    data.setDefaults()

    Surface {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            HorizontalList(
                rvData = HorizontalListData(
                    listOf(data, data)
                ),
                interaction = SnippetInteractions()
            )
        }
    }
}
