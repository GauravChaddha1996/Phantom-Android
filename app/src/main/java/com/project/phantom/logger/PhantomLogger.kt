package com.project.phantom.logger

import android.util.Log

object PhantomLogger {
    fun logException(exception: Throwable) {
        Log.e("phantom", exception.stackTraceToString())
    }
}