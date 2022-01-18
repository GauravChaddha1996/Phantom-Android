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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.R
import com.project.phantom.getScreenWidth
import com.project.phantom.theme.PhantomColorName.Error
import com.project.phantom.theme.PhantomFontStyle.LabelLarge
import com.project.phantom.ui.button.ButtonData
import com.project.phantom.ui.button.PhantomButton
import com.project.phantom.ui.button.PhantomButtonType
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.commons.FontData
import com.project.phantom.ui.ghost.PhantomGhost
import com.project.phantom.ui.ghost.PhantomGhostData
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PhantomLCE(data: PhantomLceData?, interaction: PhantomLceInteraction) {
    data ?: return
    Box(modifier = Modifier.fillMaxSize()) {
        LceLoader(data)
        LceError(data, interaction)
        LceNoResult(data)
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
            scaleOut(spring(stiffness = Spring.StiffnessMediumLow), targetScale = 2f)
    ) {
        PhantomGhost(
            data = PhantomGhostData(
                bgColor = data.phantomGhostColor,
                size = getScreenWidth(times = 0.35f).value
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
            val retryTextData = TextData(
                text = LocalContext.current.getString(R.string.retry),
                font = FontData(LabelLarge),
                color = ColorData(Error)
            )
            PhantomText(
                data = data.errorMessage.setDefaults(
                    defaultText = LocalContext.current.getString(R.string.something_went_wrong)
                ),
                textAlign = TextAlign.Center
            )
            PhantomButton(
                data = ButtonData(retryTextData, PhantomButtonType.TEXT),
                onClick = {
                    interaction.onRetryClicked()
                }
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun BoxScope.LceNoResult(
    data: PhantomLceData
) {
    AnimatedVisibility(
        visible = data.showNoResult,
        modifier = Modifier.Companion.align(Alignment.Center),
        enter = fadeIn(spring(stiffness = Spring.StiffnessMedium)),
        exit = fadeOut(spring(stiffness = Spring.StiffnessMedium))
    ) {
        PhantomText(
            data = data.noResultMessage.setDefaults(
                defaultText = LocalContext.current.getString(R.string.no_results_found)
            ),
            textAlign = TextAlign.Center
        )
    }
}

interface PhantomLceInteraction {
    fun onRetryClicked()
}

@Preview
@Composable
fun TestPhantomLCE() {
    val data = PhantomLceData.getEmptyResultData(null)
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
