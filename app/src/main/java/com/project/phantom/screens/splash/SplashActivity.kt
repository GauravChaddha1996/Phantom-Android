package com.project.phantom.screens.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.R
import com.project.phantom.Utils
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.home.view.HomeActivity
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.theme.PhantomTheme
import com.project.phantom.ui.ghost.PhantomGhost
import com.project.phantom.ui.ghost.PhantomGhostData
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhantomTheme {
                Surface {
                    SplashScreen()
                }
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    fun SplashScreen(
        ghostAnimationDelay: Long = 1000L,
        ghostAnimationScaleInDuration: Int = 1000,
        screenTotalTime: Long = 5000L
    ) {
        var isGhostVisible by remember { mutableStateOf(false) }
        LaunchedEffect(key1 = true, block = {
            delay(ghostAnimationDelay)
            isGhostVisible = true
        })
        LaunchedEffect(key1 = true, block = {
            delay(screenTotalTime)
            withContext(Dispatchers.Main) {
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
        Box(Modifier.fillMaxSize()) {
            Column(
                Modifier
                    .align(Alignment.Center)
                    .animateContentSize(tween(durationMillis = ghostAnimationScaleInDuration)),
                verticalArrangement = Arrangement.spacedBy(PaddingStyle.gigantic),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PhantomText(
                    data = TextData(LocalContext.current.getString(R.string.app_name))
                        .setDefaults(
                            fontStyle = PhantomFontStyle.SEMIBOLD_940,
                            colorName = PhantomColorName.RED_400
                        )
                )
                AnimatedVisibility(
                    visible = isGhostVisible,
                    enter = scaleIn(animationSpec = tween(durationMillis = ghostAnimationScaleInDuration))
                ) {
                    PhantomGhost(
                        data = PhantomGhostData(Utils.getScreenWidth().times(other = 0.5f).value)
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun TestSplashScreen() {
        Surface {
            SplashScreen()
        }
    }
}
