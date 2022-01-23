package com.project.phantom.ui.snippets.productDual

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
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
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.ui.card.ElevatedCard
import com.project.phantom.ui.grid.GridData
import com.project.phantom.ui.grid.PhantomGrid
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImage
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Composable
fun ProductDualSnippet(
    data: ProductDualSnippetData?,
    interaction: ProductDualSnippetInteraction
) {
    data ?: return
    ElevatedCard {
        Column(
            modifier = Modifier.clickable { interaction.onProductDualSnippetClicked(data) }
        ) {
            Box {
                GetImage(data.imageData)
                GetNewTag(newTag = data.newTagText)
            }
            GetTextSection(data)
        }
    }
}

@Composable
private fun GetImage(imageData: ImageData?) {
    PhantomImage(
        data = imageData,
        modifier = Modifier.aspectRatio(ratio = 0.87f),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun BoxScope.GetNewTag(newTag: TextData?) {
    newTag ?: return
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
private fun GetTextSection(data: ProductDualSnippetData) {
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
                    .padding(end = PaddingStyle.medium)
            )
            PhantomText(data = data.cost)
        }
        Column(
            modifier = Modifier.padding(horizontal = PaddingStyle.large),
            verticalArrangement = Arrangement.spacedBy(PaddingStyle.small)
        ) {
            PhantomText(
                data = data.shortDesc,
                modifier = Modifier.alpha(ContentAlpha.medium)
            )
            PhantomText(data = data.brand)
        }
    }
}

interface ProductDualSnippetInteraction {
    fun onProductDualSnippetClicked(data: ProductDualSnippetData?)
}

@Preview
@Composable
private fun TestProductDualSnippet() {
    val data = ProductDualSnippetData(
        id = 1,
        name = TextData("Solid black shirt"),
        shortDesc = TextData("Soft cotton shirt made by good workers"),
        brand = TextData("By Adidas"),
        cost = TextData("$200"),
        imageData = ImageData("url")
    )
    data.setDefaults()

    Surface {
        PhantomGrid(
            GridData(2, listOf(data, data)),
            interaction = SnippetInteractions()
        )
    }
}
