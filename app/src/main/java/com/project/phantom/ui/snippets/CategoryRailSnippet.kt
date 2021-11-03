package com.project.phantom.ui.snippets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.data.atoms.FontData
import com.project.phantom.data.atoms.TextData
import com.project.phantom.data.snippets.CategoryRailSnippetApiData
import com.project.phantom.data.snippets.CategoryRailSnippetData
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.atoms.PhantomText

@Composable
fun CategoryRailSnippet(
    data: CategoryRailSnippetData?,
    interaction: CategoryRailSnippetInteraction
) {
    data ?: return

    Card(
        modifier = Modifier
            .clickable { interaction.onCategoryRailSnippetClicked(data) }
            .size(200.dp, 200.dp),
        elevation = 12.dp
    ) {
        Column {
            PhantomText(data = data.name)
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
                data = CategoryRailSnippetData.create(
                    CategoryRailSnippetApiData(
                        1,
                        TextData("Category name", font = FontData(PhantomFontStyle.MEDIUM_400))
                    )
                ),
                interaction = object : CategoryRailSnippetInteraction {
                    override fun onCategoryRailSnippetClicked(data: CategoryRailSnippetData?) {

                    }
                })
        }
    }
}