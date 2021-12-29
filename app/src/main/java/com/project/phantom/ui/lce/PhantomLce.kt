package com.project.phantom.ui.lce

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButton
import com.project.phantom.ui.button.PhantomButtonType
import com.project.phantom.ui.ghost.PhantomGhost
import com.project.phantom.ui.ghost.PhantomGhostData
import com.project.phantom.ui.text.PhantomText

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PhantomLCE(data: PhantomLceData?, interaction: PhantomLceInteraction) {
    data ?: return
    Box(modifier = Modifier.fillMaxSize()) {
        LceLoader(data)
        LceError(data, interaction)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun BoxScope.LceLoader(data: PhantomLceData) {
    AnimatedVisibility(
        visible = data.showLoader,
        modifier = Modifier.Companion.align(Alignment.Center),
        enter = fadeIn(spring(stiffness = Spring.StiffnessMediumLow)) +
            scaleIn(spring(stiffness = Spring.StiffnessMediumLow)),
        exit = fadeOut(spring(stiffness = Spring.StiffnessMediumLow)) +
            scaleOut(spring(stiffness = Spring.StiffnessMediumLow), 2f)
    ) {
        PhantomGhost(
            data = PhantomGhostData(
                size = 120.dp.value,
                legs = 5,
                bgColor = PhantomColorName.RED_300,
                eyeColor = PhantomColorName.RED_400
            )
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun BoxScope.LceError(
    data: PhantomLceData,
    interaction: PhantomLceInteraction
) {
    AnimatedVisibility(
        visible = data.showError,
        modifier = Modifier.Companion.align(Alignment.Center),
        enter = fadeIn(spring(stiffness = Spring.StiffnessMedium)),
        exit = fadeOut(spring(stiffness = Spring.StiffnessMedium))
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PhantomText(data = data.errorMessage, textAlign = TextAlign.Center)
            PhantomButton(
                data = ButtonData(data.retryTextData, PhantomButtonType.TEXT),
                onClick = {
                    interaction.onRetryClicked()
                }
            )
        }
    }
}

interface PhantomLceInteraction {
    fun onRetryClicked()
}

@Preview
@Composable
fun TestPhantomLCE() {
    val data = PhantomLceData.getLoadingData()
    val state = remember { mutableStateOf(data) }
    Surface {
        PhantomLCE(
            data = state.value,
            interaction = object : PhantomLceInteraction {
                override fun onRetryClicked() {
                    state.value = PhantomLceData.getContentData()
                }
            }
        )
    }
}
