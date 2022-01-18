package com.project.phantom.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.project.phantom.theme3.AppTypography

@Stable
@Immutable
enum class PhantomFontStyle {
    DisplayLarge,
    DisplayMedium,
    DisplaySmall,
    HeadlineLarge,
    HeadlineMedium,
    HeadlineSmall,
    TitleLarge,
    TitleMedium,
    TitleSmall,
    BodyLarge,
    BodyMedium,
    BodySmall,
    LabelLarge,
    LabelMedium,
    LabelSmall,
}

fun PhantomFontStyle?.resolve(): TextStyle {
    return when (this) {
        PhantomFontStyle.DisplayLarge -> AppTypography.displayLarge
        PhantomFontStyle.DisplayMedium -> AppTypography.displayMedium
        PhantomFontStyle.DisplaySmall -> AppTypography.displaySmall
        PhantomFontStyle.HeadlineLarge -> AppTypography.headlineLarge
        PhantomFontStyle.HeadlineMedium -> AppTypography.headlineMedium
        PhantomFontStyle.HeadlineSmall -> AppTypography.headlineSmall
        PhantomFontStyle.TitleLarge -> AppTypography.titleLarge
        PhantomFontStyle.TitleMedium -> AppTypography.titleMedium
        PhantomFontStyle.TitleSmall -> AppTypography.titleSmall
        PhantomFontStyle.BodyLarge -> AppTypography.bodyLarge
        PhantomFontStyle.BodyMedium -> AppTypography.bodyMedium
        PhantomFontStyle.BodySmall -> AppTypography.bodySmall
        PhantomFontStyle.LabelLarge -> AppTypography.labelLarge
        PhantomFontStyle.LabelMedium -> AppTypography.labelMedium
        PhantomFontStyle.LabelSmall -> AppTypography.labelSmall
        null -> AppTypography.bodyMedium
    }
}
