package com.project.phantom.theme

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.project.phantom.PhantomApplication.Companion.INSTANCE
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.theme.color.ColorScheme1
import com.project.phantom.theme.color.ColorScheme4
import com.project.phantom.theme.color.PhantomColorScheme
import com.project.phantom.theme.color.PhantomColorToColorMap
import com.project.phantom.theme.color.formPhantomColorToColorMap
import com.project.phantom.theme.font.AppTypography

const val AppPrefs = "app_prefs"
const val KeyColorSchemeCode = "color_scheme_code"
const val KeyDarkModeState = "dark_mode_state"

val LocalSharedPrefs: ProvidableCompositionLocal<SharedPreferences> =
    staticCompositionLocalOf { INSTANCE.getSharedPreferences(AppPrefs, Context.MODE_PRIVATE) }

val LocalDarkModeState: ProvidableCompositionLocal<Boolean> = staticCompositionLocalOf { true }

val LocalColorScheme: ProvidableCompositionLocal<PhantomColorScheme> =
    staticCompositionLocalOf { ColorScheme1 }

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val sharedPrefs = LocalSharedPrefs.current
    var currentColorScheme by remember { mutableStateOf(getSavedColorScheme(sharedPrefs)) }
    var currentDarkModeState by remember { mutableStateOf(getSavedDarkModeState(sharedPrefs)) }
    val prefsChangeListener = remember {
        SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            when (key) {
                KeyColorSchemeCode -> {
                    currentColorScheme = getSavedColorScheme(sharedPrefs)
                }
                KeyDarkModeState -> {
                    currentDarkModeState = getSavedDarkModeState(sharedPrefs)
                }
            }
        }
    }
    sharedPrefs.registerOnSharedPreferenceChangeListener(prefsChangeListener)

    CompositionLocalProvider(
        values = arrayOf(
            LocalColorScheme provides currentColorScheme,
            LocalDarkModeState provides currentDarkModeState
        )
    ) {
        // Update the AppThemeColors and PhantomColorToColorMap according to current LocalSelectedTheme
        AppThemeColors = currentColorScheme.getScheme(currentDarkModeState)
        PhantomColorToColorMap = formPhantomColorToColorMap()
        MaterialTheme(
            colorScheme = AppThemeColors,
            typography = AppTypography,
            content = content
        )
    }
}

private fun getSavedColorScheme(sharedPrefs: SharedPreferences): PhantomColorScheme {
    val savedColorSchemeCode =
        sharedPrefs.getInt(KeyColorSchemeCode, ColorScheme4.getCode())
    return PhantomColorScheme.convertCodeToScheme(savedColorSchemeCode)
}

private fun getSavedDarkModeState(sharedPrefs: SharedPreferences): Boolean {
    return sharedPrefs.getBoolean(KeyDarkModeState, true)
}
