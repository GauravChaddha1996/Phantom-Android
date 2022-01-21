package com.project.phantom.ui.snippets.sortMethod

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
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.PaddingStyle.large
import com.project.phantom.theme.PaddingStyle.small
import com.project.phantom.theme3.AppThemeColors
import com.project.phantom.ui.text.PhantomText

@Composable
fun SortMethodSnippet(
    data: SortMethodData,
    interaction: SortMethodSnippetInteraction
) {
    val isSelected = data.selected == true
    Row(
        modifier = Modifier
            .padding(horizontal = large, vertical = small)
            .clip(CornerStyle.extra)
            .border(if (isSelected) 0.dp else 1.dp, AppThemeColors.outline, CornerStyle.extra)
            .background(
                if (isSelected) AppThemeColors.primary
                    .copy(alpha = 0.2f)
                    .compositeOver(
                        AppThemeColors.primaryContainer
                    ) else Color.Transparent
            )
            .clickable { interaction.onSortMethodClicked(data) }
    ) {
        PhantomText(
            data = data.name,
            modifier = Modifier
                .weight(weight = 1f)
                .padding(large),
            color = AppThemeColors.onPrimaryContainer
        )
        val iconAlpha = if (data.selected == true) ContentAlpha.high else ContentAlpha.disabled
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            modifier = Modifier
                .alpha(alpha = iconAlpha)
                .align(Alignment.CenterVertically)
                .padding(large)
        )
    }
}

interface SortMethodSnippetInteraction {
    fun onSortMethodClicked(sortMethodData: SortMethodData)
}
