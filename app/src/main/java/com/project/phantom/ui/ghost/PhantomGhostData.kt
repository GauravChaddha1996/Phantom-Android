package com.project.phantom.ui.ghost

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.color.AppThemeColors

data class PhantomGhostData(
    val width: Float,
    val aspectRatio: Float = 0.7f,
    val height: Float = width.div(aspectRatio),
    val numberOfLegs: Int = 3,
    val bgColor: Color = AppThemeColors.primary,
    val borderColor: Color = AppThemeColors.inversePrimary,
    val eyeColor: Color = AppThemeColors.primaryContainer,

    val eyeOneWidth: Dp = width.times(other = 0.21f).dp,
    val eyeOneHeight: Dp = height.times(other = 0.18f).dp,
    val eyeTwoWidth: Dp = width.times(other = 0.15f).dp,
    val eyeTwoHeight: Dp = height.times(other = 0.14f).dp,
    val eyeGap: Dp = width.times(other = 0.08f).dp
)
