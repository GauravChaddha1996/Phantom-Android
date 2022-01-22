package com.project.phantom.screens.product.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.phantom.LaunchOnce
import com.project.phantom.PhantomApplication
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.product.domain.ProductFetcherImpl
import com.project.phantom.screens.product.domain.ProductPageCurator
import com.project.phantom.screens.product.domain.ProductService
import com.project.phantom.screens.product.domain.ProductViewModelImpl
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
import com.project.phantom.ui.snippets.stepper.StepperSnippet
import org.koin.android.ext.android.get
import retrofit2.Retrofit

@Composable
fun ProductBottomSheet(initModel: ProductPageInitModel) {
    val viewModel = remember {
        val retrofit: Retrofit = PhantomApplication.INSTANCE.get()
        val service = retrofit.create(ProductService::class.java)
        val fetcher = ProductFetcherImpl(service = service)
        ProductViewModelImpl(
            initModel = initModel,
            fetcher = fetcher,
            curator = ProductPageCurator()
        )
    }
    val state = viewModel.state
    LaunchOnce { viewModel.loadPage() }

    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.925f)
    ) {
        VerticalList(
            rvDataState = state.rvDataState,
            interaction = remember { SnippetInteractions() },
            verticalArrangement = Arrangement.spacedBy(PaddingStyle.zero),
            contentPadding = PaddingValues(
                top = PaddingStyle.large,
                bottom = PaddingStyle.nova
            )
        )
        PhantomLCE(
            data = state.lceState,
            interaction = object : PhantomLceInteraction {
                override fun onRetryClicked() {
                    viewModel.loadPage()
                }
            }
        )
        AnimatedVisibility(
            visible = state.stepperSnippetData != null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = PaddingStyle.medium),
            enter = slideInVertically { it / 2 }
        ) {
            StepperSnippet(data = state.stepperSnippetData!!)
        }
    }
}
