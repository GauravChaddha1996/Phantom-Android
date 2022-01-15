package com.project.phantom.ui.snippets.sortMethod

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.screens.category.view.LocalCategoryScreenColors
import com.project.phantom.theme.PaddingStyle.extra
import com.project.phantom.theme.PaddingStyle.large
import com.project.phantom.theme.PaddingStyle.small
import com.project.phantom.ui.text.PhantomText

@Composable
fun SortMethodSnippet(
    data: SortMethodData,
    interaction: SortMethodSnippetInteraction
) {
    Row(
        modifier = Modifier
            .padding(horizontal = large, vertical = small)
            .clip(RoundedCornerShape(extra))
            .clickable { interaction.onSortMethodClicked(data) }
            .background(LocalCategoryScreenColors.current.sortButtonBgColor)
    ) {
        PhantomText(
            data = data.name,
            modifier = Modifier
                .weight(1f)
                .padding(large),
            color = LocalCategoryScreenColors.current.sortButtonTextColor
        )
        LocalContentAlpha
        val iconAlpha = if (data.selected == true) ContentAlpha.high else ContentAlpha.disabled
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = LocalCategoryScreenColors.current.sortButtonTickColor,
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
