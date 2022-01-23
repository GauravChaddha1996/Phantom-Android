package com.project.phantom.theme.color

import androidx.compose.material3.ColorScheme

interface PhantomColorScheme {

    companion object {

        @Suppress("MagicNumber")
        fun convertCodeToScheme(code: Int): PhantomColorScheme {
            return when (code) {
                1 -> ColorScheme1
                2 -> ColorScheme2
                3 -> ColorScheme3
                4 -> ColorScheme4
                else -> ColorScheme1
            }
        }
    }

    fun getName(): String
    fun getCode(): Int

    fun getScheme(isDarkTheme: Boolean): ColorScheme {
        return if (isDarkTheme) getDarkScheme() else getLightScheme()
    }

    fun getLightScheme(): ColorScheme
    fun getDarkScheme(): ColorScheme
}
