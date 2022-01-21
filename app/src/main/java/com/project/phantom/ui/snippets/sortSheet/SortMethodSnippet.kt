package com.project.phantom.ui.snippets.sortSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.theme.AppThemeColors
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.text.PhantomText

@Composable
fun SortMethodSnippet(
    data: SortMethodData,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = PaddingStyle.large, vertical = PaddingStyle.small)
            .clip(CornerStyle.extra)
            .border(
                width = if (isSelected) 0.dp else 1.dp,
                color = if (isSelected) Color.Transparent else AppThemeColors.outline,
                shape = CornerStyle.extra
            )
            .background(
                color = if (isSelected) {
                    AppThemeColors.primary
                        .copy(alpha = 0.2f)
                        .compositeOver(AppThemeColors.primaryContainer)
                } else {
                    Color.Transparent
                }
            )
            .clickable { onClick.invoke() }
    ) {
        PhantomText(
            data = data.name,
            modifier = Modifier
                .weight(weight = 1f)
                .padding(PaddingStyle.large),
            color = AppThemeColors.onPrimaryContainer
        )
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            modifier = Modifier
                .alpha(alpha = if (isSelected) ContentAlpha.high else ContentAlpha.disabled)
                .align(Alignment.CenterVertically)
                .padding(PaddingStyle.large)
        )
    }
}
