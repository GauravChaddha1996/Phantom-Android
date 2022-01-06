package com.project.phantom.screens.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), KoinComponent, CoroutineScope {
    override val coroutineContext: CoroutineContext by lazy {
        viewModelScope.coroutineContext + Dispatchers.Default + defaultPhantomCEH
    }

    protected abstract val defaultPhantomCEH: CoroutineExceptionHandler
}
