package com.project.phantom.ui.atoms

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.project.phantom.ui.image.PhantomImageData

@Composable
fun PhantomImage(data: PhantomImageData?, modifier: Modifier) {

    // Check for visibility
    if (data == null || data.url.isEmpty()) {
        return
    }

    // Some common stuff for our image request
    val builder: ImageRequest.Builder.() -> Unit = {
        placeholder(ColorDrawable(android.graphics.Color.DKGRAY))
    }

    // add the view here
    Image(
        painter = rememberImagePainter(data = data.url, builder = builder),
        contentDescription = null,
        modifier = modifier
    )
}

@Preview
@Composable
fun TestPhantomImage() {
    PhantomImage(
        data = null,
        modifier = Modifier
            .alpha(0.2f)
            .padding(8.dp)
            .background(Color.Blue)
    )
}