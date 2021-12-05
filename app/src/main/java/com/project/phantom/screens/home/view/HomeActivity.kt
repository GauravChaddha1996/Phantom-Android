package com.project.phantom.screens.home.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.home.domain.HomeViewModel
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.theme.PhantomTheme
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.PhantomTextData
import com.project.phantom.ui.text.TextData
import org.koin.core.component.inject

class HomeActivity : BaseActivity() {

    private val homeViewModel: HomeViewModel by inject()
    private val appBarHeight = 56.dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(SnippetInteractions(), homeViewModel)
        }
        homeViewModel.loadPage()
    }

    @Composable
    fun HomeScreen(interaction: SnippetInteractions, homeViewModel: HomeViewModel) {
        PhantomTheme {
            Surface {
                val state = homeViewModel.state
                var topAppBarShowing by remember { mutableStateOf(true) }
                val nestedScrollConnection = rvNestedScrollConnection(
                    topAppBarShowing = topAppBarShowing,
                    updateTopAppBarShowing = {
                        topAppBarShowing = it
                    }
                )

                // Add views here
                val topAppBarHeightAnim by getTopAppBarHeightAnim(topAppBarShowing)
                SwipeRefresh(
                    state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
                    onRefresh = {
                        homeViewModel.refreshPage()
                    },
                    indicator = { swipeRefreshState, refreshTrigger ->
                        SwipeRefreshIndicator(
                            state = swipeRefreshState,
                            refreshTriggerDistance = refreshTrigger,
                            modifier = Modifier
                                .padding(top = appBarHeight)
                                .graphicsLayer {
                                    translationY = topAppBarHeightAnim.value
                                })
                    }
                ) {
                    VerticalList(
                        rvDataState = state.rvDataState,
                        interaction = interaction,
                        modifier = Modifier.nestedScroll(nestedScrollConnection),
                        contentPadding = PaddingValues(
                            top = appBarHeight + PaddingStyle.large,
                            bottom = PaddingStyle.large
                        )
                    )
                    PhantomLCE(
                        data = state.lceState,
                        interaction = object : PhantomLceInteraction {
                            override fun onRetryClicked() {
                                homeViewModel.loadPage()
                            }
                        })
                }
                GetTopAppBar(topAppBarShowing)
            }
        }
    }

    @Composable
    private fun rvNestedScrollConnection(
        topAppBarShowing: Boolean,
        updateTopAppBarShowing: (Boolean) -> Unit
    ): NestedScrollConnection {
        val nestedScrollConnection = object : NestedScrollConnection {
            var finalOffset: Float = 0f
            val finalOffsetLimit = 200f

            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                val yScroll = available.y
                finalOffset += yScroll
                finalOffset = finalOffset.coerceIn(-finalOffsetLimit, finalOffsetLimit)
                if (finalOffset == finalOffsetLimit && !topAppBarShowing) {
                    updateTopAppBarShowing.invoke(true)
                } else if (finalOffset == -finalOffsetLimit && topAppBarShowing) {
                    updateTopAppBarShowing.invoke(false)
                }

                return super.onPreScroll(available, source)
            }
        }
        return nestedScrollConnection
    }

    @Composable
    private fun GetTopAppBar(topAppBarShowing: Boolean) {
        val topAppBarHeightAnim by getTopAppBarHeightAnim(topAppBarShowing)
        TopAppBar(
            modifier = Modifier
                .height(appBarHeight)
                .graphicsLayer {
                    translationY = topAppBarHeightAnim.value
                },
            title = {
                PhantomText(
                    data = PhantomTextData.create(
                        TextData("Phantom"),
                        fontStyle = PhantomFontStyle.SEMIBOLD_700
                    )
                )
            }, navigationIcon = {
                PhantomText(
                    data = PhantomTextData.create(
                        TextData("II"),
                        fontStyle = PhantomFontStyle.SEMIBOLD_700
                    )
                )
            }, actions = {
                PhantomText(
                    data = PhantomTextData.create(
                        TextData("A1"),
                        fontStyle = PhantomFontStyle.SEMIBOLD_700
                    )
                )
            })
    }

    @Composable
    private fun getTopAppBarHeightAnim(topAppBarShowing: Boolean) = animateDpAsState(
        targetValue = if (topAppBarShowing) 0.dp else appBarHeight.unaryMinus().times(3),
        animationSpec = tween(700)
    )
}