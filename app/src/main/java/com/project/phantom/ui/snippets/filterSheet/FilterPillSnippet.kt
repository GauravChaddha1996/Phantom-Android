package com.project.phantom.ui.snippets.filterSheet

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.category.models.FilterPillData
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.theme.color.AppThemeColors
import com.project.phantom.ui.text.PhantomText

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FilterPillSnippet(
    pill: FilterPillData
) {
    var isSelected by remember { mutableStateOf(pill.selected == true) }
    Row(
        modifier = Modifier
            .clip(CornerStyle.medium)
            .border(1.dp, AppThemeColors.outline, CornerStyle.medium)
            .background(
                if (isSelected) {
                    AppThemeColors.primary
                        .copy(alpha = 0.2f)
                        .compositeOver(AppThemeColors.primaryContainer)
                } else {
                    Color.Transparent
                }
            )
            .clickable {
                isSelected = !isSelected
                pill.selected = isSelected
            }
            .alpha(if (isSelected) ContentAlpha.high else ContentAlpha.disabled)
            .padding(PaddingStyle.medium, PaddingStyle.small),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PhantomText(
            data = pill.name,
            modifier = Modifier.padding(PaddingStyle.zero)
        )
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            modifier = Modifier
                .padding(start = PaddingStyle.small)
                .size(20.dp)
        )
    }
}
