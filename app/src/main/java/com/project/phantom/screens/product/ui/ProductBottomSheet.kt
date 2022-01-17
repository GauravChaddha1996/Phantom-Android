package com.project.phantom.screens.product.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.phantom.LaunchOnce
import com.project.phantom.PhantomApplication
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.product.domain.ProductFetcherImpl
import com.project.phantom.screens.product.domain.ProductPageCurator
import com.project.phantom.screens.product.domain.ProductService
import com.project.phantom.screens.product.domain.ProductViewModelImpl
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
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
            .fillMaxHeight(fraction = 0.8f)
    ) {
        VerticalList(
            rvDataState = state.rvDataState,
            interaction = remember { SnippetInteractions() },
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
