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
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

class CategoryPageTopAppBar {

    @Composable
    fun Get(
        state: CategoryScreenState,
        backLayerData: BackLayerData,
        backClickable: () -> Unit,
        closeClickable: () -> Unit,
        filterClickable: () -> Unit,
        sortClickable: () -> Unit
    ) {
        SmallTopAppBar(
            title = { GetTitle(state, backLayerData) },
            navigationIcon = { GetNavigationIcon(backLayerData, backClickable, closeClickable) },
            actions = { GetAppBarActions(state, backLayerData, filterClickable, sortClickable) },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = AppThemeColors.primaryContainer,
                titleContentColor = AppThemeColors.onPrimaryContainer,
                navigationIconContentColor = AppThemeColors.onPrimaryContainer,
                actionIconContentColor = AppThemeColors.onPrimaryContainer
            )
        )
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    private fun GetTitle(
        state: CategoryScreenState,
        backLayerData: BackLayerData
    ) {
        AnimatedContent(backLayerData.isActive()) { backLayerActive ->
            PhantomText(
                data = when {
                    backLayerActive -> TextData().setDefaults(
                        text = when {
                            backLayerData.showFilterInBackLayer -> stringResource(id = R.string.filter)
                            backLayerData.showSortInBackLayer -> stringResource(id = R.string.sort)
                            else -> null
                        }
                    )
                    else -> state.pageTitle
                },
                modifier = Modifier.Companion.padding(start = PaddingStyle.small)
            )
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    private fun GetNavigationIcon(
        backLayerData: BackLayerData,
        backClickable: () -> Unit,
        closeClickable: () -> Unit
    ) {
        AnimatedContent(backLayerData.isActive()) { backLayerActive ->
            val clickable = if (backLayerActive) closeClickable else backClickable
            val imageVector = if (backLayerActive) Icons.Default.Close else Icons.Default.ArrowBack
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .padding(start = PaddingStyle.medium)
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

    @Composable
    private fun RowScope.GetAppBarActions(
        state: CategoryScreenState,
        backLayerData: BackLayerData,
        filterClickable: () -> Unit,
        sortClickable: () -> Unit
    ) {
        AnimatedVisibility(
            visible = backLayerData.isInactive() && state.lceState.isSuccessOrNoResultState(),
            enter = slideInHorizontally { it },
            exit = fadeOut() + slideOutHorizontally { it }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(PaddingStyle.medium),
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
                .padding(PaddingStyle.small)
        )
    }
}
