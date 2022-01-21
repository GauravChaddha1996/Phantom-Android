package com.project.phantom.screens.splash

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.project.phantom.LaunchOnce
import com.project.phantom.R
import com.project.phantom.getScreenWidth
import com.project.phantom.koin.SplashAndHomeScopeId
import com.project.phantom.koin.SplashAndHomeScopeName
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.home.domain.HomeRepo
import com.project.phantom.screens.home.view.HomeActivity
import com.project.phantom.theme.AppThemeColors
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.ghost.PhantomGhost
import com.project.phantom.ui.ghost.PhantomGhostData
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class SplashActivity : BaseActivity() {

    private val splashTotalTime = 3000L
    private val appNameFadeInDuration = 600
    private val splashFadeOutDuration = 500
    private val ghostEntryAnimDelay = 800L
    private val ghostScaleInAnimDuration = 600
    private val splashAndHomeScope: Scope = getKoin().getOrCreateScope(
        scopeId = SplashAndHomeScopeId,
        qualifier = named(SplashAndHomeScopeName)
    )
    private val homeRepo: HomeRepo by splashAndHomeScope.inject()

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    @Preview
    override fun Content() {
        var isSplashVisible by remember { mutableStateOf(true) }
        var isGhostVisible by remember { mutableStateOf(false) }
        var isAppNameVisible by remember { mutableStateOf(false) }
        val systemUiController = rememberSystemUiController()

        LaunchOnce {
            isAppNameVisible = true
            homeRepo.fetch()
        }
        LaunchGhostEntryAnimEffect(onCompletion = { isGhostVisible = true })
        LaunchSplashExitEffect(onScreenExitAnimationStart = { isSplashVisible = false })
        SideEffect { systemUiController.setStatusBarColor(AppThemeColors.primaryContainer) }

        // Add views here
        Box(
            Modifier
                .fillMaxSize()
                .background(AppThemeColors.primaryContainer)
        ) {
            AnimatedVisibility(
                visible = isSplashVisible,
                exit = fadeOut(tween(splashFadeOutDuration)),
                modifier = Modifier.align(Alignment.Center)
            ) {
                val columnModifier = if (isAppNameVisible) {
                    Modifier.animateContentSize(tween(durationMillis = ghostScaleInAnimDuration))
                } else {
                    Modifier
                }
                Column(
                    columnModifier,
                    verticalArrangement = Arrangement.spacedBy(PaddingStyle.gigantic),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GetAppNameText(isAppNameVisible)
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
    private fun GetAppNameText(isAppNameVisible: Boolean) {
        AnimatedVisibility(
            visible = isAppNameVisible,
            enter = fadeIn(tween(appNameFadeInDuration))
        ) {
            PhantomText(
                data = TextData().setDefaults(
                    defaultText = stringResource(id = R.string.app_name),
                    textStyle = PhantomTextStyle.Splash,
                    color = PhantomColor.Primary
                )
            )
        }
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
