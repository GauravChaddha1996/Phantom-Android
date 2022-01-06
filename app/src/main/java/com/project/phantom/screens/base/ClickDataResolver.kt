package com.project.phantom.screens.base

import android.util.Log
import com.project.phantom.screens.category.view.CategoryActivity
import com.project.phantom.screens.category.view.CategoryPageInitModel
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.click.OpenCategoryClickData
import com.project.phantom.ui.click.OpenProductClickData

object ClickDataResolver {
    fun resolve(clickData: ClickData?, activity: BaseActivity?) {
        clickData ?: return
        activity ?: return
        when (clickData) {
            is OpenProductClickData -> {
                Log.d("phantom", "open product : ${clickData.productId}")
            }
            is OpenCategoryClickData -> {
                clickData.categoryId ?: return
                CategoryActivity.start(activity, CategoryPageInitModel(clickData.categoryId))
            }
        }
    }
}
