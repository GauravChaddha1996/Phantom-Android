package com.project.phantom.screens.base

import android.util.Log
import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.click.OpenCategoryClickData
import com.project.phantom.ui.click.OpenProductClickData

object ClickDataResolver {
    fun resolve(clickData: ClickData?) {
        clickData ?: return
        when (clickData) {
            is OpenProductClickData -> {
                Log.d("phantom", "open product : ${clickData.productId}")
            }
            is OpenCategoryClickData -> {
                Log.d("phantom", "open category : ${clickData.categoryId}")
            }
        }
    }
}
