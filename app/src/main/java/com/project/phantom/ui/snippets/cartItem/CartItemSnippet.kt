package com.project.phantom.ui.snippets.cartItem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.R
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.ui.card.ElevatedCard
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImage
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@Preview
@Composable
fun TestCartItemSnippet() {
    CartItemSnippet(
        CartItemData(
            id = 1,
            name = TextData("Product name"),
            shortDescription = TextData("A little bit of short desc."),
            brandAndCategory = TextData("Brand and category here"),
            image = ImageData(""),
            count = TextData("Qty. 2"),
            cost = TextData("₹500")
        ).apply { setDefaults() },
        SnippetInteractions()
    )
}

@Composable
fun CartItemSnippet(data: CartItemData, interaction: CartItemSnippetInteraction) {
    ElevatedCard {
        Row(
            modifier = Modifier.padding(PaddingStyle.large)
        ) {
            GetImage(data)
            GetTopContainer(data)
            GetBottomContainer(data, interaction)
        }
    }
}

@Composable
private fun RowScope.GetImage(data: CartItemData) {
    Box(
        modifier = Modifier
            .align(Alignment.Top)
            .fillMaxWidth(fraction = 0.25f)
            .aspectRatio(ratio = 0.75f)
            .clip(CornerStyle.large)
            .background(Color.Red)
    ) {
        PhantomImage(
            data = data.image,
            modifier = Modifier
                .fillMaxSize()
                .clip(CornerStyle.large),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun RowScope.GetTopContainer(data: CartItemData) {
    Column(
        modifier = Modifier
            .weight(1f)
            .align(Alignment.Top)
            .padding(start = PaddingStyle.large, end = PaddingStyle.medium),
        verticalArrangement = Arrangement.spacedBy(PaddingStyle.small)
    ) {
        PhantomText(data = data.name)
        PhantomText(
            data = data.shortDescription,
            modifier = Modifier.alpha(ContentAlpha.medium)
        )
        PhantomText(
            data = data.brandAndCategory,
            modifier = Modifier.padding(top = PaddingStyle.nano)
        )
    }
}

@Composable
fun RowScope.GetBottomContainer(data: CartItemData, interaction: CartItemSnippetInteraction) {
    Column(
        modifier = Modifier.align(Alignment.Top),
        verticalArrangement = Arrangement.spacedBy(PaddingStyle.medium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PhantomText(data = data.count)
        GetStepper(interaction, data)
        PhantomText(data = data.cost)
    }
}

@Composable
private fun GetStepper(
    interaction: CartItemSnippetInteraction,
    data: CartItemData
) {
    Row(
        modifier = Modifier
            .clip(CornerStyle.medium)
            .border(1.dp, AppThemeColors.outline, CornerStyle.medium)
            .padding(PaddingStyle.zero)
            .background(AppThemeColors.primaryContainer),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_remove),
            contentDescription = null,
            modifier = Modifier
                .size(size = 28.dp)
                .padding(
                    top = PaddingStyle.small,
                    bottom = PaddingStyle.small,
                    start = PaddingStyle.small,
                    end = PaddingStyle.nano
                )
                .clickable { interaction.removeItem(data) }
        )
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier
                .size(size = 28.dp)
                .padding(
                    top = PaddingStyle.small,
                    bottom = PaddingStyle.small,
                    start = PaddingStyle.nano,
                    end = PaddingStyle.small
                )
                .clickable { interaction.addItem(data) }
        )
    }
}

interface CartItemSnippetInteraction {
    fun addItem(cartItemData: CartItemData)
    fun removeItem(cartItemData: CartItemData)
}
