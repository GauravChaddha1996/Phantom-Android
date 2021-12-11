package com.project.phantom.koin

import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.home.domain.HomeFetcherImpl
import com.project.phantom.screens.home.domain.HomeService
import com.project.phantom.screens.home.domain.HomeViewModel
import com.project.phantom.screens.home.domain.HomeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val HomeModule = module {

    viewModel {
        val retrofit: Retrofit = get()
        val homeService = retrofit.create(HomeService::class.java)
        val homeFetcher = HomeFetcherImpl(homeService)
        val curator = BaseSnippetCurator()
        HomeViewModelImpl(homeFetcher, curator)
    } bind HomeViewModel::class
}
