package com.project.phantom.screens.home.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.project.phantom.LaunchOnce
import com.project.phantom.R
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.home.domain.HomeViewModel
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.theme3.AppThemeColors
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val state = homeViewModel.state
        val systemUiController = rememberSystemUiController()

        LaunchOnce { homeViewModel.loadPage() }
        SideEffect { systemUiController.setStatusBarColor(AppThemeColors.primaryContainer) }

        Column {
            val scrollBehaviour = remember { TopAppBarDefaults.pinnedScrollBehavior() }
            val nestedScrollConnection = remember { scrollBehaviour.nestedScrollConnection }
            CenterAlignedTopAppBar(
                title = {
                    PhantomText(
                        data = TextData().setDefaults(
                            defaultText = stringResource(id = R.string.app_name),
                            fontStyle = PhantomFontStyle.CenterTopAppBarLarge
                        )
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppThemeColors.primaryContainer,
                    titleContentColor = AppThemeColors.primary
                ),
                scrollBehavior = scrollBehaviour
            )
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = state.isRefreshing),
                onRefresh = homeViewModel::refreshPage,
                indicator = { swipeRefreshState, refreshTriggerDistance ->
                    GetSwipeRefreshIndicator(swipeRefreshState, refreshTriggerDistance)
                }
            ) {
                GetVerticalList(state.rvDataState, nestedScrollConnection)
                GetPhantomLce(state)
            }
        }
    }

    @Composable
    private fun GetSwipeRefreshIndicator(
        swipeRefreshState: SwipeRefreshState,
        refreshTriggerDistance: Dp
    ) {
        SwipeRefreshIndicator(
            state = swipeRefreshState,
            refreshTriggerDistance = refreshTriggerDistance
        )
    }

    @Composable
    private fun GetVerticalList(
        rvDataState: List<SnippetData>,
        nestedScrollConnection: NestedScrollConnection
    ) {
        VerticalList(
            rvDataState = rvDataState,
            interaction = remember { SnippetInteractions(this) },
            contentPadding = PaddingValues(
                top = PaddingStyle.large,
                bottom = PaddingStyle.large
            ),
            modifier = Modifier.nestedScroll(nestedScrollConnection)
        )
    }

    @Composable
    private fun GetPhantomLce(state: HomeScreenState) {
        PhantomLCE(
            data = state.lceState,
            interaction = object : PhantomLceInteraction {
                override fun onRetryClicked() {
                    homeViewModel.loadPage()
                }
            }
        )
    }
}
