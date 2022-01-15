package com.project.phantom.screens.category.view

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColorName.GREY_100
import com.project.phantom.theme.PhantomColorName.GREY_400
import com.project.phantom.theme.PhantomColorName.GREY_500
import com.project.phantom.theme.PhantomColorName.GREY_800
import com.project.phantom.theme.PhantomColorName.RED_300
import com.project.phantom.theme.change
import com.project.phantom.theme.resolve

data class CategoryScreenColors(
    val backLayerBackground: Color,
    val sortButtonBgColor: Color,
    val sortButtonTextColor: Color,
    val sortButtonTickColor: Color,
    val filterUiSectionHeaderColor: Color,
    val filterPillUnselectedTextColor: Color,
    val filterPillSelectedTextColor: Color,
    val filterPillUnselectedBgColor: Color,
    val filterPillSelectedBgColor: Color,
    val filterPillUnselectedIconColor: Color,
    val filterPillSelectedIconColor: Color
) {
    companion object {

        fun get(baseColorName: PhantomColorName) =
            CategoryScreenColors(
                backLayerBackground = baseColorName.resolve(),
                sortButtonBgColor = baseColorName.change(tint = 600).resolve(),
                sortButtonTextColor = GREY_100.resolve(),
                sortButtonTickColor = GREY_100.resolve(),
                filterUiSectionHeaderColor = GREY_800.resolve(),
                filterPillUnselectedTextColor = GREY_500.resolve(),
                filterPillUnselectedBgColor = baseColorName.change(tint = 200).resolve(),
                filterPillUnselectedIconColor = GREY_400.resolve(),
                filterPillSelectedTextColor = GREY_100.resolve(),
                filterPillSelectedBgColor = baseColorName.change(tint = 600).resolve(),
                filterPillSelectedIconColor = GREY_100.resolve()
            )
    }
}

val LocalCategoryScreenColors = compositionLocalOf {
    CategoryScreenColors.get(RED_300)
}
