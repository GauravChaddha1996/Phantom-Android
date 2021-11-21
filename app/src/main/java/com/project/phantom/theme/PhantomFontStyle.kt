package com.project.phantom.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.squareup.moshi.Json

@Stable
@Immutable
enum class PhantomFontStyle {
    @Json(name = "light_100")
    LIGHT_100,

    @Json(name = "light_200")
    LIGHT_200,

    @Json(name = "light_300")
    LIGHT_300,

    @Json(name = "light_400")
    LIGHT_400,

    @Json(name = "light_500")
    LIGHT_500,

    @Json(name = "light_600")
    LIGHT_600,

    @Json(name = "light_700")
    LIGHT_700,

    @Json(name = "light_800")
    LIGHT_800,

    @Json(name = "light_900")
    LIGHT_900,

    @Json(name = "regular_100")
    REGULAR_100,

    @Json(name = "regular_200")
    REGULAR_200,

    @Json(name = "regular_300")
    REGULAR_300,

    @Json(name = "regular_400")
    REGULAR_400,

    @Json(name = "regular_500")
    REGULAR_500,

    @Json(name = "regular_600")
    REGULAR_600,

    @Json(name = "regular_700")
    REGULAR_700,

    @Json(name = "regular_800")
    REGULAR_800,

    @Json(name = "regular_900")
    REGULAR_900,

    @Json(name = "medium_100")
    MEDIUM_100,

    @Json(name = "medium_200")
    MEDIUM_200,

    @Json(name = "medium_300")
    MEDIUM_300,

    @Json(name = "medium_400")
    MEDIUM_400,

    @Json(name = "medium_500")
    MEDIUM_500,

    @Json(name = "medium_600")
    MEDIUM_600,

    @Json(name = "medium_700")
    MEDIUM_700,

    @Json(name = "medium_800")
    MEDIUM_800,

    @Json(name = "medium_900")
    MEDIUM_900,

    @Json(name = "semibold_100")
    SEMIBOLD_100,

    @Json(name = "semibold_200")
    SEMIBOLD_200,

    @Json(name = "semibold_300")
    SEMIBOLD_300,

    @Json(name = "semibold_400")
    SEMIBOLD_400,

    @Json(name = "semibold_500")
    SEMIBOLD_500,

    @Json(name = "semibold_600")
    SEMIBOLD_600,

    @Json(name = "semibold_700")
    SEMIBOLD_700,

    @Json(name = "semibold_800")
    SEMIBOLD_800,

    @Json(name = "semibold_900")
    SEMIBOLD_900,

    @Json(name = "semibold_940")
    SEMIBOLD_940,

    @Json(name = "semibold_950")
    SEMIBOLD_950
}