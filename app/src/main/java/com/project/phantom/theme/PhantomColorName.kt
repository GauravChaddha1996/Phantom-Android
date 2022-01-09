package com.project.phantom.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.squareup.moshi.Json
import java.io.Serializable

@Stable
@Immutable
enum class PhantomColorName : Serializable {
    @Json(name = "black")
    BLACK,

    @Json(name = "white")
    WHITE,

    @Json(name = "blue_100")
    BLUE_100,

    @Json(name = "blue_200")
    BLUE_200,

    @Json(name = "blue_300")
    BLUE_300,

    @Json(name = "blue_400")
    BLUE_400,

    @Json(name = "blue_500")
    BLUE_500,

    @Json(name = "blue_600")
    BLUE_600,

    @Json(name = "blue_700")
    BLUE_700,

    @Json(name = "blue_800")
    BLUE_800,

    @Json(name = "blue_900")
    BLUE_900,

    @Json(name = "red_100")
    RED_100,

    @Json(name = "red_200")
    RED_200,

    @Json(name = "red_300")
    RED_300,

    @Json(name = "red_400")
    RED_400,

    @Json(name = "red_500")
    RED_500,

    @Json(name = "red_600")
    RED_600,

    @Json(name = "red_700")
    RED_700,

    @Json(name = "red_800")
    RED_800,

    @Json(name = "red_900")
    RED_900,

    @Json(name = "yellow_100")
    YELLOW_100,

    @Json(name = "yellow_200")
    YELLOW_200,

    @Json(name = "yellow_300")
    YELLOW_300,

    @Json(name = "yellow_400")
    YELLOW_400,

    @Json(name = "yellow_500")
    YELLOW_500,

    @Json(name = "yellow_600")
    YELLOW_600,

    @Json(name = "yellow_700")
    YELLOW_700,

    @Json(name = "yellow_800")
    YELLOW_800,

    @Json(name = "yellow_900")
    YELLOW_900,

    @Json(name = "green_100")
    GREEN_100,

    @Json(name = "green_200")
    GREEN_200,

    @Json(name = "green_300")
    GREEN_300,

    @Json(name = "green_400")
    GREEN_400,

    @Json(name = "green_500")
    GREEN_500,

    @Json(name = "green_600")
    GREEN_600,

    @Json(name = "green_700")
    GREEN_700,

    @Json(name = "green_800")
    GREEN_800,

    @Json(name = "green_900")
    GREEN_900,

    @Json(name = "grey_100")
    GREY_100,

    @Json(name = "grey_200")
    GREY_200,

    @Json(name = "grey_300")
    GREY_300,

    @Json(name = "grey_400")
    GREY_400,

    @Json(name = "grey_500")
    GREY_500,

    @Json(name = "grey_600")
    GREY_600,

    @Json(name = "grey_700")
    GREY_700,

    @Json(name = "grey_800")
    GREY_800,

    @Json(name = "grey_900")
    GREY_900
}
