package com.project.phantom.ui.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.ElevationStyle
import com.project.phantom.theme.color.AppThemeColors

@Composable
fun OutlinedCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(
        modifier = modifier,
        shape = CornerStyle.large,
        backgroundColor = AppThemeColors.surfaceVariant.copy(alpha = 0.5f),
        contentColor = AppThemeColors.onSurfaceVariant,
        border = BorderStroke(1.dp, AppThemeColors.outline),
        elevation = ElevationStyle.none
    ) {
        content()
    }
}

@Composable
fun ElevatedCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppThemeColors.surface,
    contentColor: Color = AppThemeColors.onSurface,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = CornerStyle.large,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = ElevationStyle.small
    ) {
        content()
    }
}

@Composable
fun FilledCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = AppThemeColors.primaryContainer.copy(alpha = 0.4f),
    contentColor: Color = AppThemeColors.onPrimaryContainer,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = CornerStyle.large,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = ElevationStyle.none
    ) {
        content()
    }
}
