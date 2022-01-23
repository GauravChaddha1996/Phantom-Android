package com.project.phantom.screens.home.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
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
import com.project.phantom.screens.cart.view.CartFab
import com.project.phantom.screens.home.domain.HomeViewModel
import com.project.phantom.theme.ElevationStyle
import com.project.phantom.theme.KeyColorSchemeCode
import com.project.phantom.theme.KeyDarkModeState
import com.project.phantom.theme.LocalColorScheme
import com.project.phantom.theme.LocalDarkModeState
import com.project.phantom.theme.LocalSharedPrefs
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.color.PhantomColorScheme
import com.project.phantom.theme.color.resolve
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.card.FilledCard
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
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

        val scrollBehaviour = remember { TopAppBarDefaults.pinnedScrollBehavior() }
        val nestedScrollConnection = remember { scrollBehaviour.nestedScrollConnection }
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { GetTopAppBar(scope, scaffoldState, scrollBehaviour) },
            drawerBackgroundColor = AppThemeColors.background,
            drawerGesturesEnabled = true,
            drawerScrimColor = PhantomColor.Scrim.resolve(),
            drawerContentColor = AppThemeColors.onBackground,
            drawerElevation = ElevationStyle.large,
            drawerContent = { GetDrawerContent(scope, scaffoldState) },
            floatingActionButton = { CartFab(this) },
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = false,
            backgroundColor = AppThemeColors.background,
            contentColor = AppThemeColors.onBackground,
            content = {
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
        )
    }

    @Composable
    private fun GetDrawerContent(scope: CoroutineScope, scaffoldState: ScaffoldState) {
        val sharedPrefs = LocalSharedPrefs.current
        val isDarkMode = LocalDarkModeState.current
        val selectedColorScheme = LocalColorScheme.current
        val allColorSchemes = remember {
            val colorSchemeList = mutableListOf<PhantomColorScheme>()
            val numberOfSchemes = 4
            for (code in 1..numberOfSchemes) {
                val colorScheme = PhantomColorScheme.convertCodeToScheme(code)
                colorSchemeList.add(colorScheme)
            }
            colorSchemeList
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(PaddingStyle.large),
            contentPadding = PaddingValues(PaddingStyle.large)
        ) {
            item {
                PhantomText(
                    data = TextData().setDefaults(
                        text = stringResource(id = R.string.color_schemes),
                        textStyle = PhantomTextStyle.HeadlineMediumBold,
                        defaultMaxLines = 1,
                        overflow = TextOverflow.Visible
                    ),
                    autoSize = true
                )
            }
            allColorSchemes.forEach { colorSchemeItem ->
                item {
                    val colorScheme = colorSchemeItem.getScheme(isDarkMode)
                    val isSelected = colorSchemeItem.getCode() == selectedColorScheme.getCode()
                    FilledCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                sharedPrefs
                                    .edit()
                                    .putInt(KeyColorSchemeCode, colorSchemeItem.getCode())
                                    .apply()
                                scope.launch { scaffoldState.drawerState.close() }
                            },
                        backgroundColor = colorScheme.primary
                    ) {
                        Row {
                            PhantomText(
                                data = TextData().setDefaults(
                                    text = colorSchemeItem.getName(),
                                    textStyle = PhantomTextStyle.TitleSemiLarge,
                                    defaultMaxLines = 1,
                                    overflow = TextOverflow.Visible
                                ),
                                autoSize = true,
                                color = colorScheme.onPrimary,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(
                                        horizontal = PaddingStyle.medium,
                                        vertical = PaddingStyle.large
                                    )
                            )
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                modifier = Modifier
                                    .alpha(alpha = if (isSelected) ContentAlpha.high else ContentAlpha.disabled)
                                    .align(Alignment.CenterVertically)
                                    .padding(PaddingStyle.large),
                                tint = colorScheme.onPrimary
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun GetTopAppBar(
        scope: CoroutineScope,
        scaffoldState: ScaffoldState,
        scrollBehaviour: TopAppBarScrollBehavior
    ) {
        val sharedPrefs = LocalSharedPrefs.current
        val savedDarkModeState = LocalDarkModeState.current
        CenterAlignedTopAppBar(
            title = {
                PhantomText(
                    data = TextData().setDefaults(
                        text = stringResource(id = R.string.app_name),
                        textStyle = PhantomTextStyle.HeadlineMediumBold
                    )
                )
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = PaddingStyle.medium)
                        .clickable {
                            scope.launch { scaffoldState.drawerState.open() }
                        }
                )
            },
            actions = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_dark_mode),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = PaddingStyle.medium)
                        .clickable {
                            sharedPrefs
                                .edit()
                                .putBoolean(KeyDarkModeState, savedDarkModeState.not())
                                .apply()
                        }
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = AppThemeColors.primaryContainer,
                titleContentColor = AppThemeColors.primary
            ),
            scrollBehavior = scrollBehaviour
        )
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
