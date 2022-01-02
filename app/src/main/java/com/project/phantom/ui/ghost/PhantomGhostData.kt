package com.project.phantom.ui.ghost

import com.project.phantom.theme.PhantomColorName

data class PhantomGhostData(
    val size: Float,

    // Curve-related data points
    val bgColor: PhantomColorName = PhantomColorName.RED_300,
    val curveMaxMovementX: Float = size.times(other = 0.035f),
    val curveMaxMovementY: Float = size.times(other = 0.12f),
    val curveMovementDuration: Int = 1100,

    // Legs-related data points
    val legs: Int = 3,
    val legsMaxWaveAmplitude: Float = size.times(other = 0.3f),
    val legsMovement: Float = legsMaxWaveAmplitude.times(other = 0.65f),
    val legsMovementDuration: Int = 1300,
    val legsMovementDelay: Int = 300,

    // Eye-related data points
    val eyeColor: PhantomColorName = PhantomColorName.WHITE,
    val eyeSize: Float = size.times(other = 0.2f),
    val eyeTopPadding: Float = size.times(other = 0.25f),
    val eyeMovementDuration: Int = 2100,
    val eyeMovementCircleRadius: Float = eyeSize.times(other = 0.15f),
    val eyeBlinkSize: Float = size.times(other = 0.26f),
    val eyeBlinkDuration: Int = 125,
    val eyeBlinkDelay: Int = 900
)

data class PhantomGhostCurveAnimationData(
    val size: Float,
    val legs: Int,
    val curveMaxMovementX: Float,
    val curveMaxMovementY: Float,
    val legsMaxWaveAmplitude: Float,
    val curveMovementValue: Float,
    val legsMovementValue: Float
) {
    // General data points
    val startX: Float = curveMaxMovementX - curveMovementValue
    val startY: Float = curveMaxMovementY - curveMovementValue
    val endX: Float = size - curveMaxMovementX + curveMovementValue
    val endY = size - curveMaxMovementY.times(2)
    val midX = (endX - startX).times(0.5f)

    // Curve-related data points
    val curveWidth = endX - startX
    val curveHeight = endY - startY

    // Legs-related data points
    val legsWavelength = curveWidth.div(legs + 0.5f)
    val legsHalfWavelength = legsWavelength.times(0.5f)
    val legsQuarterWavelength = legsHalfWavelength.times(0.5f)
    val legsWaveAmplitude = legsMaxWaveAmplitude - legsMovementValue
}
