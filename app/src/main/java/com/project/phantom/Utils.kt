package com.project.phantom

object Utils {

    fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean {
        return this.isNullOrEmpty().not()
    }
}