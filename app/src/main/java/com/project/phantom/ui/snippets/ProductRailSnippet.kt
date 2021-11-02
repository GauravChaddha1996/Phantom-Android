package com.project.phantom.ui.snippets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.data.atoms.ImageData
import com.project.phantom.data.atoms.PhantomTextData
import com.project.phantom.data.atoms.TextData
import com.project.phantom.data.snippets.ProductRailSnippetData
import com.project.phantom.data.snippets.ProductRailSnippetApiData
import com.project.phantom.ui.atoms.PhantomImage
import com.project.phantom.ui.atoms.PhantomText

@Composable
fun ProductRailSnippet(data: ProductRailSnippetData?, interaction: ProductRailSnippetInteraction) {
    data ?: return

    Card(
        modifier = Modifier
            .clickable { interaction.onProductRailSnippetClicked(data) }
            .size(200.dp, 450.dp),
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
private fun GetTextSection(data: ProductRailSnippetData) {
    Row {
        Column(Modifier.weight(3f, true)) {
            PhantomText(data = data.name)
            PhantomText(data = data.shortDesc)
            Row {
                PhantomText(data = PhantomTextData.create(TextData("By")))
                PhantomText(data = data.brand)
            }
            Row {
                PhantomText(data = PhantomTextData.create(TextData("In")))
                PhantomText(data = data.category)
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

interface ProductRailSnippetInteraction {
    fun onProductRailSnippetClicked(data: ProductRailSnippetData?)
}

@Preview
@Composable
private fun TestProductRailSnippet() {

    Surface {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            ProductRailSnippet(
                data = ProductRailSnippetData.create(
                    ProductRailSnippetApiData(
                        1,
                        TextData("Product name"),
                        TextData("Product short desc a  a short desc Productai short desc"),
                        TextData("Product brand"),
                        TextData("Product category"),
                        TextData("COST"),
                        ImageData("url")
                    )
                ),
                interaction = object : ProductRailSnippetInteraction {
                    override fun onProductRailSnippetClicked(data: ProductRailSnippetData?) {

                    }
                })
        }
    }
}