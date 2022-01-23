package com.project.phantom.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.phantom.ui.click.AddProductClickData

@Entity(tableName = "products")
data class ProductDbModel(
    @PrimaryKey val id: Int,
    val name: String,
    val shortDescription: String,
    val brandAndCategory: String,
    val image: String,
    val count: Int,
    val cost: Int
) {
    companion object {
        fun create(clickData: AddProductClickData, existingCount: Int): ProductDbModel? {
            val unitCost = clickData.cost ?: return null
            val finalCount = existingCount + 1
            return ProductDbModel(
                id = clickData.productId ?: return null,
                name = clickData.name ?: return null,
                shortDescription = clickData.shortDescription ?: return null,
                brandAndCategory = clickData.brandAndCategory ?: return null,
                image = clickData.image ?: return null,
                count = finalCount,
                cost = unitCost
            )
        }
    }
}
