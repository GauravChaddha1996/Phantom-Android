package com.project.phantom.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object CornerStyle {
    val small = RoundedCornerShape(4.dp)
    val medium = RoundedCornerShape(8.dp)
    val large = RoundedCornerShape(12.dp)
    val extra = RoundedCornerShape(16.dp)
    val topLarge = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
}
