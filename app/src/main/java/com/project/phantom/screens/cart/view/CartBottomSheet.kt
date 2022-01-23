package com.project.phantom.screens.cart.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.project.phantom.LaunchOnce
import com.project.phantom.R
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.ClickDataResolver
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.cart.domain.CartViewModel
import com.project.phantom.screens.cart.domain.CartViewModelImpl
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.click.PlaceOrderClickData
import com.project.phantom.ui.list.VerticalList
import com.project.phantom.ui.snippets.cartItem.CartItemData
import com.project.phantom.ui.snippets.stepper.StepperSnippet
import com.project.phantom.ui.snippets.stepper.StepperSnippetData
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
import kotlinx.coroutines.delay

@Composable
fun CartBottomSheet(activity: BaseActivity) {
    val viewModel: CartViewModel = remember { CartViewModelImpl() }
    val state = viewModel.state
    var orderPlaced by remember { mutableStateOf(false) }

    if (state.closeBottomSheet && !orderPlaced) {
        activity.bottomSheetHelper.closeCurrentBottomSheet()
    }
    LaunchOnce { viewModel.loadCart() }
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.8f)
            .background(AppThemeColors.background)
    ) {
        GetOrderPlaced(orderPlaced, activity)
        AnimatedVisibility(visible = !orderPlaced, exit = fadeOut()) {
            Column {
                GetTitle(state)
                GetList(state, activity, viewModel)
            }
        }
        GetStepper(
            stepperData = state.stepperSnippetData?.takeIf { !orderPlaced },
            activity = activity,
            orderPlaced = { orderPlaced = true }
        )
    }
}

@Composable
private fun BoxScope.GetOrderPlaced(
    orderPlaced: Boolean,
    activity: BaseActivity
) {
    AnimatedVisibility(
        visible = orderPlaced,
        modifier = Modifier.align(Alignment.Center)
    ) {
        PhantomText(
            data = TextData().setDefaults(
                text = stringResource(R.string.order_placed),
                textStyle = PhantomTextStyle.DisplayLarge,
                color = PhantomColor.Primary
            ),
            textAlign = TextAlign.Center
        )
        LaunchOnce(effect = {
            delay(timeMillis = 1500)
            activity.bottomSheetHelper.closeCurrentBottomSheet()
        })
    }
}

@Composable
private fun GetTitle(state: CartScreenState) {
    if (state.pageTitle != null) {
        PhantomText(
            data = state.pageTitle,
            modifier = Modifier
                .padding(PaddingStyle.large)
                .alpha(ContentAlpha.medium)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(AppThemeColors.onBackground.copy(alpha = 0.05f))

        )
    }
}

@Composable
private fun GetList(
    state: CartScreenState,
    activity: BaseActivity,
    viewModel: CartViewModel
) {
    VerticalList(
        rvDataState = state.items,
        interaction = remember {
            object : SnippetInteractions(activity = activity) {
                override fun addItem(cartItemData: CartItemData) {
                    viewModel.addItem(cartItemData.id)
                }

                override fun removeItem(cartItemData: CartItemData) {
                    viewModel.removeItem(cartItemData.id)
                }
            }
        },
        contentPadding = PaddingValues(
            start = PaddingStyle.large,
            end = PaddingStyle.large,
            top = PaddingStyle.extra,
            bottom = PaddingStyle.supernova
        )
    )
}

@Composable
private fun BoxScope.GetStepper(
    stepperData: StepperSnippetData?,
    activity: BaseActivity,
    orderPlaced: () -> Unit
) {
    AnimatedVisibility(
        visible = stepperData != null,
        modifier = Modifier.Companion
            .align(Alignment.BottomCenter)
            .padding(bottom = PaddingStyle.medium),
        enter = slideInVertically { it / 2 }
    ) {
        stepperData ?: return@AnimatedVisibility
        StepperSnippet(
            data = stepperData,
            onClick = {
                orderPlaced()
                ClickDataResolver.resolve(PlaceOrderClickData(), activity)
            }
        )
    }
}
