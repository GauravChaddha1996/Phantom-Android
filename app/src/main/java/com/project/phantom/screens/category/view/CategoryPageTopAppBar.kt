package com.project.phantom.screens.category.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.project.phantom.R
import com.project.phantom.screens.category.view.CategoryScreenState.BackLayerData
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.project.phantom.theme.PhantomFontStyle
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
        TopAppBar(
            elevation = 0.dp,
            backgroundColor = Color.Transparent,
            contentPadding = PaddingValues()
        ) {
            AnimatedContent(
                targetState = scaffoldState.isConcealed,
                modifier = Modifier.weight(1f)
            ) { isConcealed ->
                Row {
                    if (isConcealed) {
                        GetNavigationIcon(Icons.Default.ArrowBack, backClickable)
                        GetTitle(state.pageTitle)
                    } else {
                        GetNavigationIcon(Icons.Default.Close, closeClickable)
                        GetTitle(
                            TextData().setDefaults(
                                defaultText = when {
                                    backLayerData.showFilterInBackLayer -> stringResource(id = R.string.filter)
                                    backLayerData.showSortInBackLayer -> stringResource(id = R.string.sort)
                                    else -> null
                                },
                                fontStyle = PhantomFontStyle.SEMIBOLD_700,
                                colorName = PhantomColorName.GREY_900
                            )

                        )
                    }
                }
            }
            AnimatedVisibility(
                visible = scaffoldState.isConcealed && (state.lceState.showSuccess || state.lceState.showNoResult),
                enter = slideInHorizontally { it },
                exit = fadeOut() + slideOutHorizontally { it }
            ) {
                Row(
                    Modifier.fillMaxHeight(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        GetIconAndTextAction(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter_list),
                            text = stringResource(R.string.filter)
                        ) {
                            filterClickable.invoke()
                        }
                        GetIconAndTextAction(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_sort),
                            text = stringResource(R.string.sort)
                        ) {
                            sortClickable.invoke()
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun GetNavigationIcon(imageVector: ImageVector, clickable: () -> Unit) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .padding(start = 8.dp)
                .clip(CircleShape)
                .clickable { clickable.invoke() }
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = PhantomColors.resolve(PhantomColorName.GREY_900),
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
    }

    @Composable
    private fun RowScope.GetTitle(textData: TextData?) {
        PhantomText(
            data = textData,
            modifier = Modifier.Companion
                .align(Alignment.CenterVertically)
                .padding(start = 4.dp)
        )
    }

    @Composable
    private fun GetIconAndTextAction(
        imageVector: ImageVector,
        text: String,
        clickable: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .padding(end = 4.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    clickable.invoke()
                }
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = PhantomColors.resolve(PhantomColorName.GREY_800),
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            )
            PhantomText(
                data = TextData().setDefaults(
                    defaultText = text,
                    fontStyle = PhantomFontStyle.SEMIBOLD_500,
                    colorName = PhantomColorName.GREY_800
                ),
                modifier = Modifier
                    .padding(start = 2.dp, end = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}