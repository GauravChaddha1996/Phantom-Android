package com.project.phantom.screens.category.view

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.project.phantom.theme.changeAndResolve
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
                sortButtonBgColor = baseColorName.changeAndResolve(tint = 600),
                sortButtonTextColor = PhantomColors.resolve(PhantomColorName.GREY_100),
                sortButtonTickColor = PhantomColors.resolve(PhantomColorName.GREY_100),
                filterUiSectionHeaderColor = PhantomColors.resolve(PhantomColorName.GREY_800),
                filterPillUnselectedTextColor = PhantomColors.resolve(PhantomColorName.GREY_500),
                filterPillUnselectedBgColor = baseColorName.changeAndResolve(tint = 200),
                filterPillUnselectedIconColor = PhantomColors.resolve(PhantomColorName.GREY_400),
                filterPillSelectedTextColor = PhantomColors.resolve(PhantomColorName.GREY_100),
                filterPillSelectedBgColor = baseColorName.changeAndResolve(tint = 600),
                filterPillSelectedIconColor = PhantomColors.resolve(PhantomColorName.GREY_100)
            )
    }
}

val LocalCategoryScreenColors = compositionLocalOf {
    CategoryScreenColors.get(PhantomColorName.RED_300)
}
