package com.project.phantom.screens.splash

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.LaunchOnce
import com.project.phantom.R
import com.project.phantom.getScreenWidth
import com.project.phantom.koin.SplashAndHomeScopeId
import com.project.phantom.koin.SplashAndHomeScopeName
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.home.domain.HomeRepo
import com.project.phantom.screens.home.view.HomeActivity
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
    private val splashFadeInDuration = 400
    private val splashFadeOutDuration = 500
    private val splashAndHomeScope: Scope = getKoin().getOrCreateScope(
        scopeId = SplashAndHomeScopeId,
        qualifier = named(SplashAndHomeScopeName)
    )
    private val homeRepo: HomeRepo by splashAndHomeScope.inject()

    override fun getSurfaceBackgroundColor(): Color {
        return Color.Transparent
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    @Preview
    override fun Content() {
        var isSplashVisible by remember { mutableStateOf(false) }

        LaunchOnce { homeRepo.fetch() }
        LaunchOnce { isSplashVisible = true }
        LaunchSplashExitEffect(onScreenExitAnimationStart = { isSplashVisible = false })

        Box(Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = isSplashVisible,
                enter = fadeIn(tween(splashFadeInDuration)),
                exit = fadeOut(tween(splashFadeOutDuration)),
                modifier = Modifier.align(Alignment.Center)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(PaddingStyle.gigantic),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PhantomText(
                        data = TextData().setDefaults(
                            text = stringResource(id = R.string.app_name),
                            textStyle = PhantomTextStyle.DisplayLargeBold,
                            color = PhantomColor.Primary
                        )
                    )
                    PhantomGhost(
                        data = PhantomGhostData(getScreenWidth(times = 0.45f).value)
                    )
                }
            }
        }
    }

    @Composable
    private fun LaunchSplashExitEffect(onScreenExitAnimationStart: () -> Unit) {
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
}
