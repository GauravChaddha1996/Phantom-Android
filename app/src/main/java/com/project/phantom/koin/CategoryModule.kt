package com.project.phantom.koin

import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.category.domain.CategoryFetcherImpl
import com.project.phantom.screens.category.domain.CategoryService
import com.project.phantom.screens.category.domain.CategoryViewModel
import com.project.phantom.screens.category.domain.CategoryViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val CategoryModule = module {
    viewModel { params ->
        val retrofit: Retrofit = get()
        val categoryService = retrofit.create(CategoryService::class.java)
        val categoryFetcher = CategoryFetcherImpl(categoryService)
        val curator = BaseSnippetCurator()
        CategoryViewModelImpl(params.get(), categoryFetcher, curator)
    } bind CategoryViewModel::class
}
