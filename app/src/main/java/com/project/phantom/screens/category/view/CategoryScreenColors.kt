package com.project.phantom.screens.category.view

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme3.AppThemeColors

data class CategoryScreenColors(
    val backLayerBackground: Color,
    val sortMethodBgColor: Color,
    val sortMethodTextColor: Color,
    val sortMethodTickColor: Color,
    val filterUiSectionHeaderColor: Color,
    val filterPillUnselectedTextColor: Color,
    val filterPillSelectedTextColor: Color,
    val filterPillUnselectedBgColor: Color,
    val filterPillSelectedBgColor: Color,
    val filterPillUnselectedIconColor: Color,
    val filterPillSelectedIconColor: Color
) {
    companion object {

        fun get(): CategoryScreenColors {
            return CategoryScreenColors(
                backLayerBackground = AppThemeColors.primary,

                sortMethodBgColor = AppThemeColors.primaryContainer,
                sortMethodTextColor = AppThemeColors.onPrimaryContainer,
                sortMethodTickColor = AppThemeColors.onPrimaryContainer,

                filterUiSectionHeaderColor = AppThemeColors.onPrimary,

                filterPillUnselectedBgColor = AppThemeColors.primaryContainer,
                filterPillUnselectedTextColor = AppThemeColors.onPrimaryContainer,
                filterPillUnselectedIconColor = AppThemeColors.onPrimaryContainer,

                filterPillSelectedBgColor = AppThemeColors.primaryContainer,
                filterPillSelectedTextColor = AppThemeColors.onPrimaryContainer,
                filterPillSelectedIconColor = AppThemeColors.onPrimaryContainer
            )
        }
    }
}

val LocalCategoryScreenColors = compositionLocalOf {
    CategoryScreenColors.get()
}
