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
import androidx.compose.ui.unit.dp
import com.project.phantom.screens.category.models.SortMethodData
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomColors
import com.project.phantom.ui.text.PhantomText

@Composable
fun SortMethodSnippet(
    data: SortMethodData,
    interaction: SortMethodSnippetInteraction
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { interaction.onSortMethodClicked(data) }
            .background(PhantomColors.resolve(PhantomColorName.RED_600))
    ) {
        PhantomText(
            data = data.name,
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        )
        LocalContentAlpha
        val iconAlpha = if (data.selected == true) ContentAlpha.high else ContentAlpha.disabled
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = PhantomColors.resolve(PhantomColorName.GREY_100),
            modifier = Modifier
                .alpha(alpha = iconAlpha)
                .align(Alignment.CenterVertically)
                .padding(12.dp)
        )
    }
}

interface SortMethodSnippetInteraction {
    fun onSortMethodClicked(sortMethodData: SortMethodData)
}
