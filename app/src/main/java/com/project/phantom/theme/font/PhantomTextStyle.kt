package com.project.phantom.theme.font

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Stable
@Immutable
enum class PhantomTextStyle {
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

    // Custom ones
    DisplayXXXLarge,
    DisplayLargeBold,
    HeadlineMediumBold,
    TitleSemiLarge,
    BodyExtra,
    LabelExtra
}

@Suppress("ComplexMethod")
fun PhantomTextStyle.resolve(): TextStyle {
    return when (this) {
        PhantomTextStyle.DisplayLarge -> AppTypography.displayLarge
        PhantomTextStyle.DisplayMedium -> AppTypography.displayMedium
        PhantomTextStyle.DisplaySmall -> AppTypography.displaySmall
        PhantomTextStyle.HeadlineLarge -> AppTypography.headlineLarge
        PhantomTextStyle.HeadlineMedium -> AppTypography.headlineMedium
        PhantomTextStyle.HeadlineSmall -> AppTypography.headlineSmall
        PhantomTextStyle.TitleLarge -> AppTypography.titleLarge
        PhantomTextStyle.TitleMedium -> AppTypography.titleMedium
        PhantomTextStyle.TitleSmall -> AppTypography.titleSmall
        PhantomTextStyle.BodyLarge -> AppTypography.bodyLarge
        PhantomTextStyle.BodyMedium -> AppTypography.bodyMedium
        PhantomTextStyle.BodySmall -> AppTypography.bodySmall
        PhantomTextStyle.LabelLarge -> AppTypography.labelLarge
        PhantomTextStyle.LabelMedium -> AppTypography.labelMedium
        PhantomTextStyle.LabelSmall -> AppTypography.labelSmall

        // Custom ones
        PhantomTextStyle.DisplayXXXLarge -> AppTypography.displayLarge.copy(
            fontSize = 57.sp.times(other = 2.5),
            lineHeight = 64.sp.times(other = 3)
        )
        PhantomTextStyle.DisplayLargeBold -> AppTypography.displayLarge.copy(fontWeight = FontWeight.Bold)
        PhantomTextStyle.HeadlineMediumBold -> AppTypography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        PhantomTextStyle.TitleSemiLarge -> AppTypography.titleLarge.copy(fontSize = 20.sp)
        PhantomTextStyle.BodyExtra -> AppTypography.bodyLarge.copy(fontSize = 20.sp)
        PhantomTextStyle.LabelExtra -> AppTypography.labelLarge.copy(fontSize = 16.sp)
    }
}
