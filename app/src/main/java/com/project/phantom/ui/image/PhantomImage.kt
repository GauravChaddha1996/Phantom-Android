package com.project.phantom.ui.image

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.project.phantom.theme.PhantomColorName.GREY_100
import com.project.phantom.theme.PhantomColorName.GREY_200
import com.project.phantom.theme.PhantomColors

@Composable
fun PhantomImage(data: ImageData?, modifier: Modifier = Modifier) {
    // Check for visibility
    if (data == null || data.url.isNullOrEmpty()) {
        return
    }

    // Some common stuff for our image request
    val builder: ImageRequest.Builder.() -> Unit = {
        val placeholderColor = PhantomColors.resolve(GREY_200).toArgb()
        placeholder(ColorDrawable(placeholderColor))
    }

    // add the view here
    Image(
        painter = rememberImagePainter(data = data.url, builder = builder),
        contentDescription = null,
        modifier = modifier.background(PhantomColors.resolve(GREY_100))
    )
}

@Preview
@Composable
fun TestPhantomImage() {
    PhantomImage(
        data = ImageData("url")
    )
}
