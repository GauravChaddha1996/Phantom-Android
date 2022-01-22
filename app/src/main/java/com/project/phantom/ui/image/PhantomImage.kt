package com.project.phantom.ui.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter

@Composable
fun PhantomImage(
    data: ImageData?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Inside,
    alignment: Alignment = Alignment.Center
) {
    // Check for visibility
    if (data == null || data.url.isNullOrEmpty()) {
        return
    }

    // add the view here
    Image(
        painter = rememberImagePainter(data = data.url),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale,
        alignment = alignment
    )
}

@Preview
@Composable
fun TestPhantomImage() {
    PhantomImage(
        data = ImageData("url")
    )
}
