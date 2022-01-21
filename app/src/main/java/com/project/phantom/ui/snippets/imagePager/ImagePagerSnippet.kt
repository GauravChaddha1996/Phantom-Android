package com.project.phantom.ui.snippets.imagePager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerScope
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.project.phantom.getScreenHeight
import com.project.phantom.theme.CornerStyle
import com.project.phantom.theme.PaddingStyle
import com.project.phantom.ui.image.ImageData
import com.project.phantom.ui.image.PhantomImage
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagePagerSnippet(data: ImagePagerSnippetData) {
    val items = remember { data.images?.filter { it.url.isNullOrEmpty().not() } ?: emptyList() }
    if (items.isEmpty()) return

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(PaddingStyle.extra)
    ) {
        val pagerState = rememberPagerState()
        HorizontalPager(
            count = items.size,
            state = pagerState
        ) { index ->
            val item = items[index]
            GetPagerItem(item, index)
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun PagerScope.GetPagerItem(
    item: ImageData,
    index: Int
) {
    Box(
        Modifier.height(getScreenHeight(times = 0.5f))
    ) {
        PhantomImage(
            data = item,
            modifier = Modifier
                .graphicsLayer {
                    shape = CornerStyle.large
                    clip = true

                    val pageOffset = calculateCurrentOffsetForPage(index).absoluteValue

                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = 0.85.dp,
                        stop = 1.dp,
                        fraction = (1f - pageOffset.coerceIn(0f, 1f))
                    ).also { scale ->
                        scaleX = scale.value
                        scaleY = scale.value
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5.dp,
                        stop = 1.dp,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).value
                },
            contentScale = ContentScale.Fit
        )
    }
}
