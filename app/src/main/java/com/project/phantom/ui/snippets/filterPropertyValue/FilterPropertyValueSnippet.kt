package com.project.phantom.ui.snippets.filterPropertyValue

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.category.models.FilterPropertyValueData
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.project.phantom.ui.commons.ColorData
import com.project.phantom.ui.text.PhantomText

@Composable
fun FilterPropertyValueSnippet(
    propertyValue: FilterPropertyValueData
) {
    var isSelected by remember {
        mutableStateOf(propertyValue.selected == true)
    }
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(64.dp))
            .background(
                PhantomColors.resolve(
                    if (isSelected) {
                        PhantomColorName.RED_600
                    } else {
                        PhantomColorName.RED_400
                    }
                )
            )
            .clickable {
                isSelected = !isSelected
                propertyValue.selected = isSelected
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        PhantomText(
            data = propertyValue.name?.copy(
                color = ColorData(
                    if (isSelected) {
                        PhantomColorName.GREY_100
                    } else {
                        PhantomColorName.GREY_200
                    }
                )
            ),
            modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 4.dp, bottom = 8.dp)
        )
        val iconAlpha = if (isSelected) ContentAlpha.high else ContentAlpha.disabled
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = PhantomColors.resolve(PhantomColorName.GREY_100),
            modifier = Modifier
                .alpha(alpha = iconAlpha)
                .padding(start = 0.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
        )
    }
}
