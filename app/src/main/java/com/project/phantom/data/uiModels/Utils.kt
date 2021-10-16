package com.project.phantom.data.uiModels

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed


fun List<Modifier>?.merge(): Modifier {
    val mergedModifier = Modifier
    this?.forEach {
        mergedModifier.composed { it }
    }
    return mergedModifier
}