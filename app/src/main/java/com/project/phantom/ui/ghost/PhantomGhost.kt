package com.project.phantom.ui.ghost

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.project.phantom.getScreenWidth
import com.project.phantom.theme.AppTheme
import com.project.phantom.theme.color.AppThemeColors

@Preview
@Composable
fun TestPhantomGhost() {
    AppTheme {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                PhantomGhost(
                    modifier = Modifier.align(Alignment.Center),
                    data = PhantomGhostData(getScreenWidth(times = 0.5f).value)
                )
            }
        }
    }
}

@Composable
fun PhantomGhost(
    modifier: Modifier = Modifier,
    data: PhantomGhostData
) {
    val infiniteTransition = rememberInfiniteTransition()
    val ghostTranslationYState = getGhostTranslationAnimState(infiniteTransition, data)
    Box(
        modifier = modifier
            .graphicsLayer { translationY = ghostTranslationYState.value }
    ) {
        val curveShape = remember { getCurveShape(data) }
        val eyeShape = remember { getEyeShape() }

        Box(
            modifier = Modifier
                .width(data.width.dp)
                .height(data.height.dp)
                .clip(curveShape)
                .background(AppThemeColors.primary)
        )
        Row(
            modifier = Modifier.offset(
                x = data.width.times(other = 0.45f).dp,
                y = data.height.times(other = 0.25f).dp
            ),
            horizontalArrangement = Arrangement.spacedBy(data.eyeGap),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(data.eyeOneWidth)
                    .height(data.eyeOneHeight)
                    .clip(eyeShape)
                    .background(data.eyeColor)
            )
            Box(
                modifier = Modifier
                    .width(data.eyeTwoWidth)
                    .height(data.eyeTwoHeight)
                    .clip(eyeShape)
                    .background(data.eyeColor)
            )
        }
    }
}

@Composable
private fun getGhostTranslationAnimState(
    infiniteTransition: InfiniteTransition,
    data: PhantomGhostData
) = infiniteTransition.animateFloat(
    initialValue = data.height.times(other = 0.1f),
    targetValue = 0f,
    animationSpec = InfiniteRepeatableSpec(
        animation = tween(durationMillis = 800, easing = LinearOutSlowInEasing),
        repeatMode = RepeatMode.Reverse
    )
)

fun getCurveShape(data: PhantomGhostData): Shape {
    return GenericShape { size: Size, _: LayoutDirection ->
        val width = size.width
        val height = size.height

        // Head and cap related variables
        val headHeight = height.times(other = 0.35f)
        val headCapWidth = width.times(other = 0.1f)
        val headCapHeight = headHeight.times(other = 0.3f)

        // Left side related variables
        val leftSideStartX: Float = headCapWidth
        val leftSideStartY: Float = headCapHeight

        // Legs related variables
        val legsHeight: Float = height.times(other = 0.15f)
        val legsStartX: Float = leftSideStartX
        val legsStartY: Float = height - legsHeight
        val legsEndX: Float = width.times(other = 0.98f)
        val legsEndY: Float = height - legsHeight.times(other = 1.5f)
        val legsWidth = (legsEndX - legsStartX).div(data.numberOfLegs)
        val legsHeightDiff = (legsEndY - legsStartY).div(data.numberOfLegs)

        val leftSideEndX: Float = width.times(other = 0.98f)
        val leftSideEndY: Float = headHeight

        /* Drawing begins */

        // Move to starting point
        moveTo(leftSideStartX, leftSideStartY)

        // Draw the left side
        quadraticBezierTo(
            legsStartX.times(other = 0.7f),
            legsStartY.times(other = 0.8f),
            legsStartX,
            legsStartY
        )

        // Draw the legs
        relativeQuadraticBezierTo(
            legsWidth.times(other = 0.3f),
            legsHeight,
            legsWidth,
            legsHeightDiff
        )
        relativeQuadraticBezierTo(
            legsWidth.times(other = 0.55f),
            legsHeight,
            legsWidth,
            legsHeightDiff
        )
        relativeQuadraticBezierTo(
            legsWidth.times(other = 0.8f),
            legsHeight,
            legsWidth,
            legsHeightDiff
        )

        // Draw the right side
        quadraticBezierTo(width, legsEndY.times(other = 0.9f), leftSideEndX, leftSideEndY)

        // Draw the head-right side
        quadraticBezierTo(
            width.times(other = 0.99f),
            y1 = 0f,
            x2 = width.times(other = 0.5f),
            y2 = 0f
        )

        // Draw the head-left side
        quadraticBezierTo(x1 = width.times(other = 0f), y1 = 0f, x2 = 0f, y2 = headHeight)

        // Draw the cap
        relativeQuadraticBezierTo(headCapWidth.times(other = 0.5f), headCapHeight, headCapWidth, 0f)

        // Close the loop
        lineTo(leftSideStartX, leftSideStartY)
    }
}

fun getEyeShape(): Shape {
    return GenericShape { size: Size, _: LayoutDirection ->
        addOval(Rect(Offset.Zero, size))
    }
}
