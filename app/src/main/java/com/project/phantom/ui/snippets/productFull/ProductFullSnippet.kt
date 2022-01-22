package com.project.phantom.ui.snippets.productFull

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.card.ElevatedCard
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImage
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Composable
fun ProductFullSnippet(
    data: ProductFullSnippetData?,
    interaction: ProductFullSnippetInteraction
) {
    data ?: return

    Box(
        modifier = Modifier.padding(
            start = PaddingStyle.large,
            end = PaddingStyle.large,
            bottom = PaddingStyle.large
        )
    ) {
        ElevatedCard(
            modifier = Modifier.clickable { interaction.onProductFullSnippetClicked(data = data) }
        ) {
            Column {
                GetImage(data.imageData)
                GetTextSection(data)
            }
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
private fun GetTextSection(data: ProductFullSnippetData) {
    Column(
        modifier = Modifier.padding(PaddingStyle.large),
        verticalArrangement = Arrangement.spacedBy(PaddingStyle.small)
    ) {
        Row {
            PhantomText(data = data.name, modifier = Modifier.weight(1f))
            PhantomText(data = data.cost, modifier = Modifier.padding(start = PaddingStyle.medium))
        }
        PhantomText(
            data = data.longDesc,
            modifier = Modifier.alpha(ContentAlpha.medium)
        )
        PhantomText(data = data.brandAndCategory)
    }
}

interface ProductFullSnippetInteraction {
    fun onProductFullSnippetClicked(data: ProductFullSnippetData?)
}

@Preview
@Composable
private fun TestProductFullSnippet() {
    val data = ProductFullSnippetData(
        id = 1,
        name = TextData("Solid black shirt"),
        longDesc = TextData(
            "Soft cotton shirt made by well paid hard Soft cotton shirt made by well " +
                "paid hard Soft cotton shirt made by well paid hard Soft cotton shirt " +
                "made by well paid hard"
        ),
        brandAndCategory = TextData("By Adidas In Shirts"),
        cost = TextData("$200"),
        imageData = ImageData("url")
    )
    data.setDefaults()
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            ProductFullSnippet(data = data, interaction = SnippetInteractions())
        }
    }
}
