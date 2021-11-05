package com.project.phantom.screens.home.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.home.domain.HomeViewModel
import com.project.phantom.theme.PhantomTheme
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.list.VerticalList
import org.koin.core.component.inject

class HomeActivity : BaseActivity() {

    val homeViewModel: HomeViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HomeScreen() }
        homeViewModel.loadPage()
    }

    @Preview
    @Composable
    fun HomeScreen() {
        val interaction = SnippetInteractions()
        PhantomTheme {
            Surface {
                // Find the states here
                val rvDataState = homeViewModel.rvData.observeAsState()
                val lceState = homeViewModel.lceData.observeAsState()

                // Add views here
                VerticalList(rvDataState = rvDataState, interaction = interaction)
                PhantomLCE(
                    state = lceState,
                    interaction = object : PhantomLceInteraction {
                        override fun onRetryClicked() {
                            homeViewModel.loadPage()
                        }
                    })
            }
        }
    }
}