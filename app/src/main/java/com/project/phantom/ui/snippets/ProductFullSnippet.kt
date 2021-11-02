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
import com.project.phantom.data.snippets.ProductFullSnippetData
import com.project.phantom.data.snippets.ProductFullSnippetApiData
import com.project.phantom.ui.atoms.PhantomImage
import com.project.phantom.ui.atoms.PhantomText

@Composable
fun ProductFullSnippet(data: ProductFullSnippetData?, interaction: ProductFullSnippetInteraction) {
    data ?: return

    Box(
        Modifier.padding(12.dp)
    ) {
        Card(
            modifier = Modifier.clickable { interaction.onProductFullSnippetClicked(data) },
            elevation = 12.dp,
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                PhantomImage(
                    data = data.imageData,
                    modifier = Modifier
                        .aspectRatio(1.85f)
                )
                GetTextSection(data)
            }
        }
    }

}

@Composable
private fun GetTextSection(data: ProductFullSnippetData) {
    Row {
        Column(Modifier.weight(3f, true)) {
            PhantomText(data = data.name)
            PhantomText(data = data.longDesc)
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

interface ProductFullSnippetInteraction {
    fun onProductFullSnippetClicked(data: ProductFullSnippetData?)
}

@Preview
@Composable
private fun TestProductFullSnippet() {

    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            ProductFullSnippet(
                data = ProductFullSnippetData.create(
                    ProductFullSnippetApiData(
                        1,
                        TextData("Product name"),
                        TextData("Product long descriptio is here"),
                        TextData("Product brand"),
                        TextData("Product category"),
                        TextData("COST"),
                        ImageData("url")
                    )
                ),
                interaction = object : ProductFullSnippetInteraction {
                    override fun onProductFullSnippetClicked(data: ProductFullSnippetData?) {

                    }
                })
        }
    }
}