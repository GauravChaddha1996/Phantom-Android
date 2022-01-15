package com.project.phantom.ui.snippets.filterPill

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
import com.project.phantom.screens.category.view.LocalCategoryScreenColors
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.PaddingStyle.medium
import com.project.phantom.theme.PaddingStyle.small
import com.project.phantom.ui.text.PhantomText

@Composable
fun FilterPillSnippet(
    propertyValue: FilterPropertyValueData
) {
    var isSelected by remember {
        mutableStateOf(propertyValue.selected == true)
    }
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(PaddingStyle.gigantic))
            .background(
                if (isSelected) {
                    LocalCategoryScreenColors.current.filterPillSelectedBgColor
                } else {
                    LocalCategoryScreenColors.current.filterPillUnselectedBgColor
                }
            )
            .clickable {
                isSelected = !isSelected
                propertyValue.selected = isSelected
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        PhantomText(
            data = propertyValue.name,
            modifier = Modifier
                .padding(start = medium, top = medium, end = small, bottom = medium),
            color = if (isSelected) {
                LocalCategoryScreenColors.current.filterPillSelectedTextColor
            } else {
                LocalCategoryScreenColors.current.filterPillUnselectedTextColor
            }
        )
        val iconAlpha = if (isSelected) ContentAlpha.high else ContentAlpha.disabled
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = if (isSelected) {
                LocalCategoryScreenColors.current.filterPillSelectedIconColor
            } else {
                LocalCategoryScreenColors.current.filterPillUnselectedIconColor
            },
            modifier = Modifier
                .alpha(alpha = iconAlpha)
                .padding(start = 0.dp, top = medium, end = medium, bottom = medium)
        )
    }
}
