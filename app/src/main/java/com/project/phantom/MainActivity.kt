package com.project.phantom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.MutableLiveData
import com.project.phantom.data.uiModels.atoms.PhantomTextData
import com.project.phantom.data.uiModels.network.ColorData
import com.project.phantom.data.uiModels.network.FontData
import com.project.phantom.data.uiModels.network.TextData
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.theme.PhantomTheme
import com.project.phantom.ui.atoms.PhantomText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataLd = MutableLiveData<PhantomTextData>()
        GlobalScope.launch {
            delay(5000)
            repeat(100) {
                delay(2000)
                dataLd.postValue(
                    PhantomTextData.create(
                        TextData(
                            "Hello world $it",
                            ColorData(PhantomColorName.BLUE_700),
                            FontData(PhantomFontStyle.H2)
                        )
                    )
                )
            }
        }

        setContent { MainScreen(dataLd.observeAsState()) }
    }
}

@Composable
private fun MainScreen(greetingState: State<PhantomTextData?>) {
    PhantomTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = PhantomTheme.colors.background
        ) {
            Box(contentAlignment = Alignment.Center) {
                Greeting(greetingState)
            }
        }
    }
}

@Composable
fun Greeting(greetingState: State<PhantomTextData?>) {
    PhantomText(data = greetingState.value)
}
