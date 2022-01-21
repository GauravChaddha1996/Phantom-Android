package com.project.phantom.network

import com.project.phantom.PhantomApplication.Companion.INSTANCE
import com.project.phantom.R
import com.project.phantom.logger.PhantomLogger
import kotlinx.coroutines.CoroutineExceptionHandler
import retrofit2.HttpException
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

@Suppress("FunctionName")
inline fun PhantomCEH(crossinline handler: (Throwable) -> Unit): CoroutineExceptionHandler =
    object : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {
        override fun handleException(context: CoroutineContext, exception: Throwable) {
            PhantomLogger.logException(exception = exception)
            if (exception is HttpException) {
                handler.invoke(exception)
            } else {
                val genericErrorMsg = INSTANCE.getString(R.string.something_went_wrong)
                val wrappedException = Exception(genericErrorMsg, exception)
                handler.invoke(wrappedException)
            }
        }
    }
