package com.project.phantom.screens.product.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.product.domain.ProductViewModel
import com.project.phantom.theme.PhantomTheme
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList

class ProductScreen {

    @Composable
    fun Get(
        viewModel: ProductViewModel
    ) {
        val interaction = remember { SnippetInteractions() }
        val state = viewModel.state
        PhantomTheme {
            Surface {
                Box(Modifier.fillMaxSize()) {
                    VerticalList(
                        rvDataState = state.rvDataState,
                        interaction = interaction,
                        verticalArrangement = Arrangement.spacedBy(0.dp)
                    )
                    PhantomLCE(
                        data = state.lceState,
                        interaction = object : PhantomLceInteraction {
                            override fun onRetryClicked() {
                                viewModel.loadPage()
                            }
                        }
                    )
                }
            }
        }
    }
}
