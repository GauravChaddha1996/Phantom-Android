package com.project.phantom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope

@Composable
fun getScreenHeight(times: Float = 1f): Dp {
    return LocalConfiguration.current.screenHeightDp.dp.times(times)
}

@Composable
fun getScreenWidth(times: Float = 1f): Dp {
    return LocalConfiguration.current.screenWidthDp.dp.times(times)
}

fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean {
    return this.isNullOrEmpty().not()
}

@Composable
fun LaunchOnce(effect: suspend CoroutineScope.() -> Unit) {
    LaunchedEffect(key1 = true, block = effect)
}
