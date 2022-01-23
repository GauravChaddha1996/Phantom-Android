package com.project.phantom.screens.cart.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.project.phantom.LaunchOnce
import com.project.phantom.database.ProductDatabase
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.ClickDataResolver
import com.project.phantom.ui.click.OpenCartClickData
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CartFab(
    activity: BaseActivity,
    externalVisibilityCheck: () -> Boolean = { true },
    disable: Boolean = false
) {
    var newCount by remember { mutableStateOf(-1) }
    val fabAnimDuration = remember { 200 }
    val fabAnimDelay = remember { 400 }
    LaunchOnce(effect = {
        val productDatabase = ProductDatabase.getInstance()
        productDatabase.setup()
        productDatabase.getCountBus().collect {
            newCount = it
        }
    })
    AnimatedVisibility(
        visible = (newCount > 0) && externalVisibilityCheck(),
        enter = scaleIn(
            animationSpec = tween(
                durationMillis = fabAnimDuration,
                delayMillis = fabAnimDelay,
                easing = LinearEasing
            )
        ),
        exit = scaleOut(
            animationSpec = tween(
                durationMillis = fabAnimDuration,
                delayMillis = fabAnimDelay,
                easing = LinearEasing
            )
        )
    ) {
        FloatingActionButton(
            modifier = Modifier
                .alpha(if (disable) ContentAlpha.disabled else 1f),
            onClick = {
                if (!disable) ClickDataResolver.resolve(OpenCartClickData(), activity)
            }
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null
            )
        }
    }
}
