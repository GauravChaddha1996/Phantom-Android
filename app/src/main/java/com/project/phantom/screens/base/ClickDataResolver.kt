package com.project.phantom.screens.base

import com.project.phantom.screens.category.view.CategoryActivity
import com.project.phantom.screens.category.view.CategoryPageInitModel
import com.project.phantom.screens.product.ui.ProductPageInitModel
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.click.OpenCategoryClickData
import com.project.phantom.ui.click.OpenProductClickData

object ClickDataResolver {
    fun resolve(clickData: ClickData?, activity: BaseActivity?) {
        clickData ?: return
        activity ?: return
        when (clickData) {
            is OpenProductClickData -> {
                clickData.productId ?: return
                activity.bottomSheetHelper.openBottomSheet(
                    bottomSheetType = BottomSheetType.PRODUCT,
                    bottomSheetData = ProductPageInitModel(productId = clickData.productId)
                )
            }
            is OpenCategoryClickData -> {
                clickData.categoryId ?: return
                CategoryActivity.start(
                    activity = activity,
                    initModel = CategoryPageInitModel(categoryId = clickData.categoryId)
                )
            }
        }
    }
}
