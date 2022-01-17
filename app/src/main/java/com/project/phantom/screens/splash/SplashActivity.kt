package com.project.phantom.screens.splash

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.project.phantom.LaunchOnce
import com.project.phantom.R
import com.project.phantom.getScreenWidth
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.home.view.HomeActivity
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomColorName.RED_400
import com.project.phantom.theme.PhantomFontStyle.SEMIBOLD_940
import com.project.phantom.ui.ghost.PhantomGhost
import com.project.phantom.ui.ghost.PhantomGhostData
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class SplashActivity : BaseActivity() {

    private val splashTotalTime = 5000L
    private val splashFadeOutDuration = 500
    private val ghostEntryAnimDelay = 1000L
    private val ghostScaleInAnimDuration = 1000

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun Content() {
        var isSplashVisible by remember { mutableStateOf(true) }
        var isGhostVisible by remember { mutableStateOf(false) }

        LaunchGhostEntryAnimEffect(onCompletion = { isGhostVisible = true })
        LaunchSplashExitEffect(onScreenExitAnimationStart = { isSplashVisible = false })

        // Add views here
        Box(Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = isSplashVisible,
                exit = fadeOut(tween(splashFadeOutDuration)),
                modifier = Modifier.align(Alignment.Center)
            ) {
                Column(
                    Modifier.animateContentSize(tween(durationMillis = ghostScaleInAnimDuration)),
                    verticalArrangement = Arrangement.spacedBy(PaddingStyle.gigantic),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GetAppNameText()
                    GetGhostView(isGhostVisible)
                }
            }
        }
    }

    @Composable
    fun LaunchGhostEntryAnimEffect(onCompletion: () -> Unit) {
        LaunchOnce {
            delay(ghostEntryAnimDelay)
            onCompletion.invoke()
        }
    }

    @Composable
    fun LaunchSplashExitEffect(onScreenExitAnimationStart: () -> Unit) {
        LaunchOnce {
            delay(splashTotalTime)
            onScreenExitAnimationStart.invoke()
            delay(splashFadeOutDuration.toLong())
            withContext(Dispatchers.Main) {
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }

    @Composable
    private fun GetAppNameText() {
        PhantomText(
            data = TextData().setDefaults(
                defaultText = stringResource(id = R.string.app_name),
                fontStyle = SEMIBOLD_940,
                colorName = RED_400
            )
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ColumnScope.GetGhostView(isGhostVisible: Boolean) {
        AnimatedVisibility(
            visible = isGhostVisible,
            enter = scaleIn(animationSpec = tween(durationMillis = ghostScaleInAnimDuration))
        ) {
            PhantomGhost(data = PhantomGhostData(getScreenWidth(times = 0.5f).value))
        }
    }
}
