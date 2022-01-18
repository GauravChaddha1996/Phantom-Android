package com.project.phantom.ui.ghost

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.PaddingStyle
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun PhantomGhost(
    data: PhantomGhostData,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    val curveMovementValue by getCurveMovementAnim(infiniteTransition, data)
    val legsMovementValue by getLegsMovementAnim(infiniteTransition, data)
    val eyeMovementValue by getEyeMovementAnim(infiniteTransition, data)
    val eyeBlinkValue by getEyeBlinkAnim(infiniteTransition, data)

    val curveShape = getCurveShape(data, curveMovementValue, legsMovementValue)
    Box(
        modifier = modifier
            .size(data.size.dp)
            .graphicsLayer {
                shape = curveShape
                clip = true
            }
            .background(data.bgColor)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = data.eyeTopPadding.dp),
            horizontalArrangement = Arrangement.spacedBy(PaddingStyle.gigantic)
        ) {
            repeat(2) {
                val eyeShape = getEyeShape(eyeBlinkValue)
                Box(
                    Modifier
                        .size(data.eyeSize.dp)
                        .graphicsLayer {
                            shape = eyeShape
                            clip = true
                            translationX = data.eyeMovementCircleRadius *
                                sin((Math.PI.toFloat() * 2 * eyeMovementValue).div(other = 360f))
                            translationY = data.eyeMovementCircleRadius *
                                cos((Math.PI.toFloat() * 2 * eyeMovementValue).div(other = 360f))
                        }
                        .background(data.eyeColor)
                )
            }
        }
    }
}

private fun getCurveShape(
    data: PhantomGhostData,
    curveMovementValue: Float,
    legsMovementValue: Float
) = GenericShape { s, _ ->
    val curveAnimationData = PhantomGhostCurveAnimationData(
        s.width,
        data.legs,
        data.curveMaxMovementX,
        data.curveMaxMovementY,
        data.legsMaxWaveAmplitude,
        curveMovementValue,
        legsMovementValue
    )

    with(curveAnimationData) {
        moveTo(startX, endY - legsWaveAmplitude)

        // Draw the first half-leg
        relativeQuadraticBezierTo(
            0f,
            legsWaveAmplitude.times(other = 3),
            legsHalfWavelength,
            legsWaveAmplitude
        )

        // Draw the center legs
        repeat(legs - 1) {
            relativeQuadraticBezierTo(
                legsQuarterWavelength,
                -legsWaveAmplitude,
                legsHalfWavelength,
                0f
            )
            relativeQuadraticBezierTo(
                legsQuarterWavelength,
                legsWaveAmplitude,
                legsHalfWavelength,
                0f
            )
        }

        // Draw the last leg first half
        relativeQuadraticBezierTo(
            legsQuarterWavelength,
            -legsWaveAmplitude,
            legsHalfWavelength,
            0f
        )

        // Draw the last leg second half
        relativeQuadraticBezierTo(
            legsHalfWavelength,
            legsWaveAmplitude.times(2),
            legsHalfWavelength,
            -legsWaveAmplitude
        )

        // Draw a curve to the top
        quadraticBezierTo(
            endX,
            endY - curveHeight,
            midX,
            startY
        )

        // Draw a curve to the starting point
        quadraticBezierTo(
            startX,
            endY - curveHeight,
            startX,
            endY - legsWaveAmplitude
        )
    }
}

private fun getEyeShape(eyeBlinkValue: Float) = GenericShape { size, _ ->
    addOval(
        Rect(
            topLeft = Offset(0f, eyeBlinkValue),
            bottomRight = Offset(size.width, size.height - eyeBlinkValue)
        )
    )
}

@Composable
private fun getCurveMovementAnim(
    infiniteTransition: InfiniteTransition,
    data: PhantomGhostData
): State<Float> {
    return infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = data.curveMaxMovementX,
        animationSpec = InfiniteRepeatableSpec(
            tween(data.curveMovementDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
}

@Composable
private fun getLegsMovementAnim(
    infiniteTransition: InfiniteTransition,
    data: PhantomGhostData
): State<Float> {
    return infiniteTransition.animateFloat(
        initialValue = 0.dp.value,
        targetValue = data.legsMovement,
        animationSpec = InfiniteRepeatableSpec(
            tween(
                data.legsMovementDuration,
                easing = LinearEasing,
                delayMillis = data.legsMovementDelay
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
}

@Composable
private fun getEyeMovementAnim(
    infiniteTransition: InfiniteTransition,
    data: PhantomGhostData
): State<Float> {
    return infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = InfiniteRepeatableSpec(
            tween(data.eyeMovementDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
}

@Composable
private fun getEyeBlinkAnim(
    infiniteTransition: InfiniteTransition,
    data: PhantomGhostData
): State<Float> {
    return infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = data.eyeBlinkSize,
        animationSpec = InfiniteRepeatableSpec(
            tween(data.eyeBlinkDuration, data.eyeBlinkDelay, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
}

@Preview
@Composable
fun TestPhantomGhost() {
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            PhantomGhost(
                data = PhantomGhostData(240.dp.value),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
