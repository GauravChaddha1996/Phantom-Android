package com.project.phantom.theme

import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import com.project.phantom.theme.PhantomColorName.BLACK
import com.project.phantom.theme.PhantomColorName.BLUE_100
import com.project.phantom.theme.PhantomColorName.BLUE_200
import com.project.phantom.theme.PhantomColorName.BLUE_300
import com.project.phantom.theme.PhantomColorName.BLUE_400
import com.project.phantom.theme.PhantomColorName.BLUE_500
import com.project.phantom.theme.PhantomColorName.BLUE_600
import com.project.phantom.theme.PhantomColorName.BLUE_700
import com.project.phantom.theme.PhantomColorName.BLUE_800
import com.project.phantom.theme.PhantomColorName.BLUE_900
import com.project.phantom.theme.PhantomColorName.GREEN_100
import com.project.phantom.theme.PhantomColorName.GREEN_200
import com.project.phantom.theme.PhantomColorName.GREEN_300
import com.project.phantom.theme.PhantomColorName.GREEN_400
import com.project.phantom.theme.PhantomColorName.GREEN_500
import com.project.phantom.theme.PhantomColorName.GREEN_600
import com.project.phantom.theme.PhantomColorName.GREEN_700
import com.project.phantom.theme.PhantomColorName.GREEN_800
import com.project.phantom.theme.PhantomColorName.GREEN_900
import com.project.phantom.theme.PhantomColorName.GREY_100
import com.project.phantom.theme.PhantomColorName.GREY_200
import com.project.phantom.theme.PhantomColorName.GREY_300
import com.project.phantom.theme.PhantomColorName.GREY_400
import com.project.phantom.theme.PhantomColorName.GREY_500
import com.project.phantom.theme.PhantomColorName.GREY_600
import com.project.phantom.theme.PhantomColorName.GREY_700
import com.project.phantom.theme.PhantomColorName.GREY_800
import com.project.phantom.theme.PhantomColorName.GREY_900
import com.project.phantom.theme.PhantomColorName.RED_100
import com.project.phantom.theme.PhantomColorName.RED_200
import com.project.phantom.theme.PhantomColorName.RED_300
import com.project.phantom.theme.PhantomColorName.RED_400
import com.project.phantom.theme.PhantomColorName.RED_500
import com.project.phantom.theme.PhantomColorName.RED_600
import com.project.phantom.theme.PhantomColorName.RED_700
import com.project.phantom.theme.PhantomColorName.RED_800
import com.project.phantom.theme.PhantomColorName.RED_900
import com.project.phantom.theme.PhantomColorName.WHITE
import com.project.phantom.theme.PhantomColorName.YELLOW_100
import com.project.phantom.theme.PhantomColorName.YELLOW_200
import com.project.phantom.theme.PhantomColorName.YELLOW_300
import com.project.phantom.theme.PhantomColorName.YELLOW_400
import com.project.phantom.theme.PhantomColorName.YELLOW_500
import com.project.phantom.theme.PhantomColorName.YELLOW_600
import com.project.phantom.theme.PhantomColorName.YELLOW_700
import com.project.phantom.theme.PhantomColorName.YELLOW_800
import com.project.phantom.theme.PhantomColorName.YELLOW_900

object PhantomColors {

    private val colorNameToColorMap = mapOf(
        BLACK to Color(0xFF1C1C1C),
        WHITE to Color(0xFFFFFFFF),

        BLUE_100 to Color(0xFFEDF4FF),
        BLUE_200 to Color(0xFFDBE8FF),
        BLUE_300 to Color(0xFF9CC0FF),
        BLUE_400 to Color(0xFF538CEE),
        BLUE_500 to Color(0xFF256FEF),
        BLUE_600 to Color(0xFF1155CB),
        BLUE_700 to Color(0xFF1148A6),
        BLUE_800 to Color(0xFF0E3272),
        BLUE_900 to Color(0xFF082454),

        RED_100 to Color(0xFFFFEDEF),
        RED_200 to Color(0xFFFFDBE0),
        RED_300 to Color(0xFFFFB1C0),
        RED_400 to Color(0xFFFF7E8B),
        RED_500 to Color(0xFFEF4F5F),
        RED_600 to Color(0xFFE03546),
        RED_700 to Color(0xFFBF2938),
        RED_800 to Color(0xFF7D1B23),
        RED_900 to Color(0xFF4F191E),

        YELLOW_100 to Color(0xFFFEFAEC),
        YELLOW_200 to Color(0xFFFCEEC0),
        YELLOW_300 to Color(0xFFFCDF82),
        YELLOW_400 to Color(0xFFF8D149),
        YELLOW_500 to Color(0xFFF3C117),
        YELLOW_600 to Color(0xFFE9B501),
        YELLOW_700 to Color(0xFFDC9D09),
        YELLOW_800 to Color(0xFFA16E17),
        YELLOW_900 to Color(0xFF6B4900),

        GREEN_100 to Color(0xFFEBFFEF),
        GREEN_200 to Color(0xFFCFFFDB),
        GREEN_300 to Color(0xFFA3F0B5),
        GREEN_400 to Color(0xFF5FD47A),
        GREEN_500 to Color(0xFF3AB757),
        GREEN_600 to Color(0xFF24963F),
        GREEN_700 to Color(0xFF267E3E),
        GREEN_800 to Color(0xFF0E5020),
        GREEN_900 to Color(0xFF0E401D),

        GREY_100 to Color(0xFFF5F5F5),
        GREY_200 to Color(0xFFEBEBEB),
        GREY_300 to Color(0xFFD6D6D6),
        GREY_400 to Color(0xFFB5B5B5),
        GREY_500 to Color(0xFF9C9C9C),
        GREY_600 to Color(0xFF828282),
        GREY_700 to Color(0xFF696969),
        GREY_800 to Color(0xFF4F4F4F),
        GREY_900 to Color(0xFF363636)
    )

    fun resolve(colorName: PhantomColorName?): Color {
        return colorNameToColorMap[colorName] ?: Color.Unspecified
    }
}

fun phantomColor() = lightColors(
    background = Color.Yellow
)
