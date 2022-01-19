package com.project.phantom.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.project.phantom.theme.PhantomFontStyle.BodyLarge
import com.project.phantom.theme.PhantomFontStyle.BodyMedium
import com.project.phantom.theme.PhantomFontStyle.BodySmall
import com.project.phantom.theme.PhantomFontStyle.CenterTopAppBarLarge
import com.project.phantom.theme.PhantomFontStyle.DisplayLarge
import com.project.phantom.theme.PhantomFontStyle.DisplayMedium
import com.project.phantom.theme.PhantomFontStyle.DisplaySmall
import com.project.phantom.theme.PhantomFontStyle.HeadlineLarge
import com.project.phantom.theme.PhantomFontStyle.HeadlineMedium
import com.project.phantom.theme.PhantomFontStyle.HeadlineSmall
import com.project.phantom.theme.PhantomFontStyle.LabelLarge
import com.project.phantom.theme.PhantomFontStyle.LabelMedium
import com.project.phantom.theme.PhantomFontStyle.LabelSmall
import com.project.phantom.theme.PhantomFontStyle.Splash
import com.project.phantom.theme.PhantomFontStyle.TitleLarge
import com.project.phantom.theme.PhantomFontStyle.TitleMedium
import com.project.phantom.theme.PhantomFontStyle.TitleSmall
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

    // Custom ones
    Splash,
    CenterTopAppBarLarge
}

@Suppress("ComplexMethod")
fun PhantomFontStyle.resolve(): TextStyle {
    return when (this) {
        DisplayLarge -> AppTypography.displayLarge
        DisplayMedium -> AppTypography.displayMedium
        DisplaySmall -> AppTypography.displaySmall
        HeadlineLarge -> AppTypography.headlineLarge
        HeadlineMedium -> AppTypography.headlineMedium
        HeadlineSmall -> AppTypography.headlineSmall
        TitleLarge -> AppTypography.titleLarge
        TitleMedium -> AppTypography.titleMedium
        TitleSmall -> AppTypography.titleSmall
        BodyLarge -> AppTypography.bodyLarge
        BodyMedium -> AppTypography.bodyMedium
        BodySmall -> AppTypography.bodySmall
        LabelLarge -> AppTypography.labelLarge
        LabelMedium -> AppTypography.labelMedium
        LabelSmall -> AppTypography.labelSmall

        // Custom ones
        Splash -> AppTypography.displayLarge.copy(fontWeight = FontWeight.Bold)
        CenterTopAppBarLarge -> AppTypography.headlineMedium.copy(fontWeight = FontWeight.Bold)
    }
}
