package com.project.phantom.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import java.io.Serializable

@Stable
@Immutable
enum class PhantomColorName : Serializable {
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
