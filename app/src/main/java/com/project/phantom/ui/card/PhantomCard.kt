package com.project.phantom.ui.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.ElevationStyle
import com.project.phantom.theme3.AppThemeColors

@Composable
fun OutlinedCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier,
        shape = CornerStyle.large,
        backgroundColor = AppThemeColors.primaryContainer.copy(alpha = 0.2f),
        contentColor = AppThemeColors.onPrimaryContainer,
        border = BorderStroke(1.dp, AppThemeColors.outline),
        elevation = ElevationStyle.none
    ) {
        content()
    }
}

@Composable
fun ElevatedCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier,
        shape = CornerStyle.large,
        backgroundColor = AppThemeColors.surface,
        contentColor = AppThemeColors.onSurface,
        elevation = ElevationStyle.small
    ) {
        content()
    }
}

@Composable
fun FilledCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier,
        shape = CornerStyle.large,
        backgroundColor = AppThemeColors.surfaceVariant,
        contentColor = AppThemeColors.onSurfaceVariant,
        elevation = ElevationStyle.none
    ) {
        content()
    }
}
