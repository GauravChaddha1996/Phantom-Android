package com.project.phantom.ui.atoms

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
import com.project.phantom.data.atoms.ImageData
import com.project.phantom.data.atoms.PhantomImageData

@Composable
fun PhantomImage(data: PhantomImageData?, modifier: Modifier) {

    // Check for visibility
    if (data == null || data.url.isEmpty()) {
        return
    }

    // add the view here
    Image(
        painter = rememberImagePainter(data.url),
        contentDescription = null,
        modifier = modifier
    )
}

@Preview
@Composable
fun TestPhantomImage() {
    PhantomImage(
        data = PhantomImageData.create(ImageData("https://b.zmtcdn.com/data/dish_photos/fd4/a463451efa71df3b0ad558e20a686fd4.jpg?output-format=webp")),
        modifier = Modifier
            .alpha(0.2f)
            .padding(8.dp)
            .background(Color.Blue)
    )
}