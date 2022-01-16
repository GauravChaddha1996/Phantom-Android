package com.project.phantom

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Utils {

    fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean {
        return this.isNullOrEmpty().not()
    }

    @Composable
    fun getScreenWidth(): Dp {
        return LocalConfiguration.current.screenWidthDp.dp
    }

    @Composable
    fun getScreenHeight(): Dp {
        return LocalConfiguration.current.screenHeightDp.dp
    }
}
