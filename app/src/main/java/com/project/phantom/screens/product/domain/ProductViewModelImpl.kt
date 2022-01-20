package com.project.phantom.screens.product.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.product.ui.ProductPageInitModel
import com.project.phantom.screens.product.ui.ProductScreenState
import com.project.phantom.ui.lce.PhantomLceData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class ProductViewModelImpl(
    private val initModel: ProductPageInitModel,
    private val fetcher: ProductFetcher,
    private val curator: BaseSnippetCurator
) : ProductViewModel() {

    override val defaultPhantomCEH: CoroutineExceptionHandler = PhantomCEH {
        state = ProductScreenState(lceState = PhantomLceData.getErrorData(it.message))
    }

    override var state: ProductScreenState by mutableStateOf(ProductScreenState())

    override fun loadPage() {
        launch {
            state = state.copy(lceState = PhantomLceData.getLoadingData())
            val response = fetcher.fetchProductPage(initModel = initModel)
            val curatedResults = curator.curate(response.snippetSectionList)
            if (curatedResults.isNotEmpty()) {
                state = state.copy(
                    lceState = PhantomLceData.getContentData(),
                    rvDataState = curatedResults,
                    stepperSnippetData = response.stepperSnippetData?.apply { setDefaults() }
                )
            } else {
                throw Exception("Product page curation exception")
            }
        }
    }
}
