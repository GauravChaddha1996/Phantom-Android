package com.project.phantom.screens.base

import android.util.Log
import com.project.phantom.data.atoms.click.OpenCategoryClickData
import com.project.phantom.data.atoms.click.OpenProductClickData
import com.project.phantom.data.atoms.click.PhantomClickData

object ClickDataResolver {
    fun resolve(phantomClickData: PhantomClickData?) {
        phantomClickData ?: return
        when (val clickData = phantomClickData.clickData) {
            is OpenProductClickData -> {
                Log.d("phantom", "open product : ${clickData.productId}")
            }
            is OpenCategoryClickData -> {
                Log.d("phantom", "open category : ${clickData.categoryId}")
            }
        }
    }
}