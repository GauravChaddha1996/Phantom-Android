package com.project.phantom.ui.atoms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.phantom.R
import com.project.phantom.data.atoms.*
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle

@Composable
fun PhantomLCE(data: PhantomLceData, interaction: PhantomLceInteraction) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            data.showLoader -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(60.dp)
                )
            }
            data.showError -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val retryText = LocalContext.current.resources.getString(R.string.retry)
                    val retryTextData = TextData(
                        text = retryText,
                        font = FontData(PhantomFontStyle.BUTTON),
                        color = ColorData(PhantomColorName.RED_500)
                    )

                    PhantomText(data = data.errorMessage, textAlign = TextAlign.Center)
                    PhantomButton(
                        data = PhantomButtonData.create(
                            ButtonData(
                                retryTextData,
                                PhantomButtonType.TEXT
                            )
                        ),
                        onClick = {
                            interaction.onRetryClicked()
                        }
                    )
                }
            }
        }
    }
}

interface PhantomLceInteraction {
    fun onRetryClicked()
}

@Preview
@Composable
fun TestPhantomLCE() {
    val d = PhantomLceData.getErrorData("Something went wrong")
    val s = remember {
        mutableStateOf(d)
    }
    PhantomLCE(
        data = s.value,
        interaction = object : PhantomLceInteraction {
            override fun onRetryClicked() {
                s.value = PhantomLceData.getContentData()
            }
        })
}