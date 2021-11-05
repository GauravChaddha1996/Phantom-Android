package com.project.phantom.ui.snippets.productDual

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.ui.atoms.PhantomGrid
import com.project.phantom.ui.atoms.PhantomImage
import com.project.phantom.ui.atoms.PhantomText
import com.project.phantom.ui.grid.GridData
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.text.PhantomTextData
import com.project.phantom.ui.text.TextData

@Composable
fun ProductDualSnippet(
    data: ProductDualSnippetData?,
    modifier: Modifier = Modifier,
    interaction: ProductDualSnippetInteraction
) {
    data ?: return

    Card(
        modifier = modifier
            .clickable { interaction.onProductDualSnippetClicked(data) },
        elevation = 12.dp
    ) {
        Column {
            PhantomImage(
                data = data.imageData, modifier = Modifier
                    .padding(8.dp)
                    .size(184.dp, 270.dp)
            )
            GetTextSection(data)
        }
    }

}

@Composable
private fun GetTextSection(data: ProductDualSnippetData) {
    Row {
        Column(Modifier.weight(3f, true)) {
            PhantomText(data = data.name)
            PhantomText(data = data.shortDesc)
            Row {
                PhantomText(data = PhantomTextData.create(TextData("By")))
                PhantomText(data = data.brand)
            }
        }
        PhantomText(
            data = data.cost,
            textAlign = TextAlign.End,
            modifier = Modifier
                .weight(1f, true)
                .align(Alignment.CenterVertically)
        )
    }
}

interface ProductDualSnippetInteraction {
    fun onProductDualSnippetClicked(data: ProductDualSnippetData?)
}

@Preview
@Composable
private fun TestProductDualSnippet() {

    val d = ProductDualSnippetData.create(
        ProductDualSnippetApiData(
            1,
            TextData("Product name"),
            TextData("Product short desc a  a short desc Productai short desc"),
            TextData("Product brand"),
            TextData("Cost"),
            ImageData("url")
        )
    )
    val i = object : ProductDualSnippetInteraction {
        override fun onProductDualSnippetClicked(data: ProductDualSnippetData?) {

        }
    }
    Surface {
        PhantomGrid(
            mutableStateOf(
                GridData(2, listOf(d, d))
            ),
            interaction = SnippetInteractions()
        )
    }
}