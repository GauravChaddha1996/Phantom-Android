package com.project.phantom.ui.snippets.filterPropertyValue

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .background(
                PhantomColors.resolve(
                    if (isSelected) {
                        PhantomColorName.RED_600
                    } else {
                        PhantomColorName.RED_200
                    }
                )
            )
            .clickable {
                isSelected = !isSelected
                propertyValue.selected = isSelected
            }
    ) {
        PhantomText(
            data = propertyValue.name?.copy(
                color = ColorData(
                    if (isSelected) {
                        PhantomColorName.GREY_100
                    } else {
                        PhantomColorName.GREY_800
                    }
                )
            ),
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center)
        )
    }
}
