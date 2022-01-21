package com.project.phantom.screens.category.view

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.project.phantom.R
import com.project.phantom.screens.category.view.CategoryScreenState.BackLayerData
import com.project.phantom.theme.PaddingStyle.medium
import com.project.phantom.theme.PaddingStyle.small
import com.project.phantom.theme3.AppThemeColors
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

class CategoryPageTopAppBar {

    @OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
    @Composable
    fun Get(
        state: CategoryScreenState,
        scaffoldState: BackdropScaffoldState,
        backLayerData: BackLayerData,
        backClickable: () -> Unit,
        closeClickable: () -> Unit,
        filterClickable: () -> Unit,
        sortClickable: () -> Unit
    ) {
        SmallTopAppBar(
            title = { GetTitle(state, scaffoldState, backLayerData) },
            navigationIcon = { GetNavigationIcon(scaffoldState, backClickable, closeClickable) },
            actions = { GetAppBarActions(state, scaffoldState, filterClickable, sortClickable) },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = AppThemeColors.primaryContainer,
                titleContentColor = AppThemeColors.onPrimaryContainer,
                navigationIconContentColor = AppThemeColors.onPrimaryContainer,
                actionIconContentColor = AppThemeColors.onPrimaryContainer
            )
        )
    }

    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    @Composable
    private fun GetNavigationIcon(
        scaffoldState: BackdropScaffoldState,
        backClickable: () -> Unit,
        closeClickable: () -> Unit
    ) {
        AnimatedContent(!scaffoldState.isRevealed) { isConcealed ->
            val clickable = if (isConcealed) backClickable else closeClickable
            val imageVector = if (isConcealed) Icons.Default.ArrowBack else Icons.Default.Close
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .padding(start = medium)
                    .clip(CircleShape)
                    .clickable { clickable.invoke() }
            ) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }

    @ExperimentalAnimationApi
    @ExperimentalMaterialApi
    @Composable
    private fun GetTitle(
        state: CategoryScreenState,
        scaffoldState: BackdropScaffoldState,
        backLayerData: BackLayerData
    ) {
        AnimatedContent(!scaffoldState.isRevealed) { isConcealed ->
            PhantomText(
                data = when {
                    isConcealed -> state.pageTitle
                    else -> TextData().setDefaults(
                        defaultText = when {
                            backLayerData.showFilterInBackLayer -> stringResource(id = R.string.filter)
                            backLayerData.showSortInBackLayer -> stringResource(id = R.string.sort)
                            else -> null
                        }
                    )
                },
                modifier = Modifier.Companion.padding(start = small)
            )
        }
    }

    @ExperimentalMaterialApi
    @Composable
    private fun RowScope.GetAppBarActions(
        state: CategoryScreenState,
        scaffoldState: BackdropScaffoldState,
        filterClickable: () -> Unit,
        sortClickable: () -> Unit
    ) {
        AnimatedVisibility(
            visible = !scaffoldState.isRevealed && (state.lceState.showSuccess || state.lceState.showNoResult),
            enter = slideInHorizontally { it },
            exit = fadeOut() + slideOutHorizontally { it }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(medium),
                content = {
                    GetActionIcon(R.drawable.ic_filter_list, filterClickable)
                    GetActionIcon(R.drawable.ic_sort, sortClickable)
                }
            )
        }
    }

    @Composable
    private fun GetActionIcon(@DrawableRes drawableId: Int, clickable: () -> Unit) {
        Icon(
            imageVector = ImageVector.vectorResource(id = drawableId),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .clickable { clickable.invoke() }
                .padding(small)
        )
    }
}
