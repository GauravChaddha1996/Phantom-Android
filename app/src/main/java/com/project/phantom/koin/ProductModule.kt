package com.project.phantom.koin

import com.project.phantom.screens.product.domain.ProductFetcherImpl
import com.project.phantom.screens.product.domain.ProductPageCurator
import com.project.phantom.screens.product.domain.ProductService
import com.project.phantom.screens.product.domain.ProductViewModel
import com.project.phantom.screens.product.domain.ProductViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val ProductModule = module {
    viewModel { params ->
        val retrofit: Retrofit = get()
        val service = retrofit.create(ProductService::class.java)
        val fetcher = ProductFetcherImpl(service = service)
        ProductViewModelImpl(
            params[0],
            fetcher = fetcher,
            curator = ProductPageCurator()
        )
    } bind ProductViewModel::class
}
