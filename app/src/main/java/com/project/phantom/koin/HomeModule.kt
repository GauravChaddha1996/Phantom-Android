package com.project.phantom.koin

import com.project.phantom.screens.base.BaseSnippetCurator
import com.project.phantom.screens.home.domain.HomeFetcher
import com.project.phantom.screens.home.domain.HomeFetcherImpl
import com.project.phantom.screens.home.domain.HomeRepo
import com.project.phantom.screens.home.domain.HomeService
import com.project.phantom.screens.home.domain.HomeViewModel
import com.project.phantom.screens.home.domain.HomeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

const val SplashAndHomeScopeName = "SplashAndHomeScope"
const val SplashAndHomeScopeId = "SplashAndHomeScopeId"

val HomeModule = module {

    scope(named(SplashAndHomeScopeName)) {
        scoped { HomeRepo(homeFetcher = get()) }

        scoped {
            val retrofit: Retrofit = get()
            val homeService = retrofit.create(HomeService::class.java)
            HomeFetcherImpl(homeService)
        } bind HomeFetcher::class
    }

    viewModel {
        val koin = getKoin()
        val splashAndHomeScope: Scope = koin.getOrCreateScope(
            scopeId = SplashAndHomeScopeId,
            qualifier = named(SplashAndHomeScopeName)
        )
        HomeViewModelImpl(
            splashAndHomeScope = splashAndHomeScope,
            fetcher = splashAndHomeScope.get(),
            repo = splashAndHomeScope.get(),
            curator = BaseSnippetCurator()
        )
    } bind HomeViewModel::class
}
