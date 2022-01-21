package com.project.phantom.ui.image

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.project.phantom.theme.color.AppThemeColors

@Composable
fun PhantomImage(
    data: ImageData?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Inside
) {
    // Check for visibility
    if (data == null || data.url.isNullOrEmpty()) {
        return
    }

    // Some common stuff for our image request
    val builder: ImageRequest.Builder.() -> Unit = {
        val placeholderColor = AppThemeColors.primary.copy(alpha = 0.2f).toArgb()
        placeholder(ColorDrawable(placeholderColor))
    }

    // add the view here
    Image(
        painter = rememberImagePainter(data = data.url, builder = builder),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale
    )
}

@Preview
@Composable
fun TestPhantomImage() {
    PhantomImage(
        data = ImageData("url")
    )
}
