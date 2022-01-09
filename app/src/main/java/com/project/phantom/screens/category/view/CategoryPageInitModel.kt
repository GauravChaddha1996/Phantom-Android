package com.project.phantom.screens.category.view

import com.project.phantom.ui.commons.ColorData
import java.io.Serializable

data class CategoryPageInitModel(
    val categoryId: Int,
    val categoryColor: ColorData?
) : Serializable
