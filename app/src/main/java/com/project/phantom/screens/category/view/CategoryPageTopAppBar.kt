package com.project.phantom.screens.category.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData

class CategoryPageTopAppBar {

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun Get(
        state: CategoryScreenState,
        backClickable: () -> Unit,
        filterClickable: () -> Unit,
        sortClickable: () -> Unit
    ) {
        TopAppBar(
            elevation = 0.dp,
            backgroundColor = Color.Transparent,
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable { backClickable.invoke() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = PhantomColors.resolve(PhantomColorName.GREY_900),
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
            PhantomText(
                data = state.pageTitle,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 4.dp)
                    .weight(1f)
            )

            Row(
                Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    AnimatedVisibility(visible = state.lceState.showSuccess || state.lceState.showNoResult) {
                        Row {
                            GetAction(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter_list),
                                text = stringResource(R.string.filter)
                            ) {
                                filterClickable.invoke()
                            }
                            GetAction(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_sort),
                                text = stringResource(R.string.sort)
                            ) {
                                sortClickable.invoke()
                            }
                        }
                    }
                }
            )
        }
    }

    @Composable
    private fun GetAction(
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
