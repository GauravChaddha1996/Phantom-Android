package com.project.phantom.ui.snippets.cartItem

import com.project.phantom.PhantomApplication.Companion.INSTANCE
import com.project.phantom.R
import com.project.phantom.database.ProductDbModel
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData

data class CartItemData(
    val id: Int,
    val name: TextData,
    val shortDescription: TextData,
    val brandAndCategory: TextData,
    val image: ImageData,
    val count: TextData,
    val cost: TextData
) : SnippetData() {

    override fun setDefaults() {
        name.setDefaults(textStyle = PhantomTextStyle.TitleMedium)
        shortDescription.setDefaults(textStyle = PhantomTextStyle.BodyMedium)
        brandAndCategory.setDefaults(textStyle = PhantomTextStyle.BodyMedium)
        count.setDefaults(textStyle = PhantomTextStyle.TitleMedium)
        cost.setDefaults(textStyle = PhantomTextStyle.TitleMedium)
    }

    companion object {
        fun create(productDbModel: ProductDbModel) = CartItemData(
            id = productDbModel.id,
            name = TextData(productDbModel.name),
            shortDescription = TextData(productDbModel.shortDescription),
            brandAndCategory = TextData(productDbModel.brandAndCategory),
            image = ImageData(productDbModel.image),
            count = TextData(INSTANCE.getString(R.string.quantity, productDbModel.count)),
            cost = TextData(
                INSTANCE.getString(
                    R.string.rupee_cost,
                    productDbModel.cost.times(productDbModel.count)
                )
            )
        )
    }
}
