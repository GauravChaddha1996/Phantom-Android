package com.project.phantom.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName.Background
import com.project.phantom.theme.PhantomColorName.Error
import com.project.phantom.theme.PhantomColorName.OnBackground
import com.project.phantom.theme.PhantomColorName.OnPrimary
import com.project.phantom.theme.PhantomColorName.OnPrimaryContainer
import com.project.phantom.theme.PhantomColorName.OnSecondary
import com.project.phantom.theme.PhantomColorName.OnSecondaryContainer
import com.project.phantom.theme.PhantomColorName.OnSurface
import com.project.phantom.theme.PhantomColorName.OnSurfaceVariant
import com.project.phantom.theme.PhantomColorName.OnTertiary
import com.project.phantom.theme.PhantomColorName.OnTertiaryContainer
import com.project.phantom.theme.PhantomColorName.Outline
import com.project.phantom.theme.PhantomColorName.Primary
import com.project.phantom.theme.PhantomColorName.PrimaryContainer
import com.project.phantom.theme.PhantomColorName.Secondary
import com.project.phantom.theme.PhantomColorName.SecondaryContainer
import com.project.phantom.theme.PhantomColorName.Surface
import com.project.phantom.theme.PhantomColorName.Tertiary
import com.project.phantom.theme.PhantomColorName.TertiaryContainer
import com.project.phantom.theme3.AppThemeColors

object PhantomColors {

    private val colorNameToColorMap = mapOf(
        Background to AppThemeColors.background,
        OnBackground to AppThemeColors.onBackground,
        Surface to AppThemeColors.surface,
        OnSurface to AppThemeColors.onSurface,
        OnSurfaceVariant to AppThemeColors.onSurfaceVariant,
        Primary to AppThemeColors.primary,
        OnPrimary to AppThemeColors.onPrimary,
        Secondary to AppThemeColors.secondary,
        OnSecondary to AppThemeColors.onSecondary,
        Tertiary to AppThemeColors.tertiary,
        OnTertiary to AppThemeColors.onTertiary,
        PrimaryContainer to AppThemeColors.primaryContainer,
        OnPrimaryContainer to AppThemeColors.onPrimaryContainer,
        SecondaryContainer to AppThemeColors.secondaryContainer,
        OnSecondaryContainer to AppThemeColors.onSecondaryContainer,
        TertiaryContainer to AppThemeColors.tertiaryContainer,
        OnTertiaryContainer to AppThemeColors.onTertiaryContainer,
        Error to AppThemeColors.error,
        Outline to AppThemeColors.outline
    )

    fun resolve(colorName: PhantomColorName?): Color {
        return colorNameToColorMap[colorName] ?: Color.Unspecified
    }
}

fun PhantomColorName?.resolve(): Color {
    return PhantomColors.resolve(this)
}

fun phantomColor() = lightColorScheme()
