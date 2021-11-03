package com.project.phantom

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.lifecycle.MutableLiveData
import com.project.phantom.data.atoms.*
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.theme.PhantomTheme
import com.project.phantom.ui.atoms.PhantomButton
import com.project.phantom.ui.atoms.PhantomText

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataLd = MutableLiveData(
            PhantomTextData.create(
                TextData(
                    "Hello world",
                    ColorData(PhantomColorName.BLUE_700),
                    FontData(PhantomFontStyle.MEDIUM_400)
                )
            )
        )

        setContent { MainScreen(dataLd.observeAsState()) }
    }
}

@Composable
private fun MainScreen(greetingState: State<PhantomTextData?>) {
    PhantomTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            Box(contentAlignment = Alignment.Center) {
                Greeting(greetingState)
            }
            PhantomButton(data = PhantomButtonData.create(ButtonData(TextData("Click here"))))
        }
    }
}

@Composable
fun Greeting(greetingState: State<PhantomTextData?>) {
    PhantomText(data = greetingState.value)
}
