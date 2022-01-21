package com.project.phantom.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import java.io.Serializable

var AppThemeColors = LightThemeColors

@Stable
@Immutable
enum class PhantomColor : Serializable {
    Background,
    OnBackground,
    Surface,
    OnSurface,
    OnSurfaceVariant,
    Primary,
    OnPrimary,
    Secondary,
    OnSecondary,
    Tertiary,
    OnTertiary,
    PrimaryContainer,
    OnPrimaryContainer,
    SecondaryContainer,
    OnSecondaryContainer,
    TertiaryContainer,
    OnTertiaryContainer,
    Error,
    Outline,

    // Custom colors
    Scrim
}

private val phantomColorToColorMap = mapOf(
    PhantomColor.Background to AppThemeColors.background,
    PhantomColor.OnBackground to AppThemeColors.onBackground,
    PhantomColor.Surface to AppThemeColors.surface,
    PhantomColor.OnSurface to AppThemeColors.onSurface,
    PhantomColor.OnSurfaceVariant to AppThemeColors.onSurfaceVariant,
    PhantomColor.Primary to AppThemeColors.primary,
    PhantomColor.OnPrimary to AppThemeColors.onPrimary,
    PhantomColor.Secondary to AppThemeColors.secondary,
    PhantomColor.OnSecondary to AppThemeColors.onSecondary,
    PhantomColor.Tertiary to AppThemeColors.tertiary,
    PhantomColor.OnTertiary to AppThemeColors.onTertiary,
    PhantomColor.PrimaryContainer to AppThemeColors.primaryContainer,
    PhantomColor.OnPrimaryContainer to AppThemeColors.onPrimaryContainer,
    PhantomColor.SecondaryContainer to AppThemeColors.secondaryContainer,
    PhantomColor.OnSecondaryContainer to AppThemeColors.onSecondaryContainer,
    PhantomColor.TertiaryContainer to AppThemeColors.tertiaryContainer,
    PhantomColor.OnTertiaryContainer to AppThemeColors.onTertiaryContainer,
    PhantomColor.Error to AppThemeColors.error,
    PhantomColor.Outline to AppThemeColors.outline,
    // Custom colors
    PhantomColor.Scrim to AppThemeColors.onBackground.copy(0.6f)
)

fun PhantomColor?.resolve(): Color {
    return phantomColorToColorMap[this] ?: Color.Unspecified
}
