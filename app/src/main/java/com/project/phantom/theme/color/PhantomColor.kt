package com.project.phantom.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.AppThemeColors
import com.project.phantom.theme.color.PhantomColor.Background
import com.project.phantom.theme.color.PhantomColor.Error
import com.project.phantom.theme.color.PhantomColor.OnBackground
import com.project.phantom.theme.color.PhantomColor.OnPrimary
import com.project.phantom.theme.color.PhantomColor.OnPrimaryContainer
import com.project.phantom.theme.color.PhantomColor.OnSecondary
import com.project.phantom.theme.color.PhantomColor.OnSecondaryContainer
import com.project.phantom.theme.color.PhantomColor.OnSurface
import com.project.phantom.theme.color.PhantomColor.OnSurfaceVariant
import com.project.phantom.theme.color.PhantomColor.OnTertiary
import com.project.phantom.theme.color.PhantomColor.OnTertiaryContainer
import com.project.phantom.theme.color.PhantomColor.Outline
import com.project.phantom.theme.color.PhantomColor.Primary
import com.project.phantom.theme.color.PhantomColor.PrimaryContainer
import com.project.phantom.theme.color.PhantomColor.Scrim
import com.project.phantom.theme.color.PhantomColor.Secondary
import com.project.phantom.theme.color.PhantomColor.SecondaryContainer
import com.project.phantom.theme.color.PhantomColor.Surface
import com.project.phantom.theme.color.PhantomColor.Tertiary
import com.project.phantom.theme.color.PhantomColor.TertiaryContainer
import java.io.Serializable

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
    Outline to AppThemeColors.outline,
    // Custom colors
    Scrim to AppThemeColors.onBackground.copy(0.6f)
)

fun PhantomColor?.resolve(): Color {
    return phantomColorToColorMap[this] ?: Color.Unspecified
}
