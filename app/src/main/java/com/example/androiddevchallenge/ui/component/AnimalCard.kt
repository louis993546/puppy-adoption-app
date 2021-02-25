package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable
fun AnimalCard(
    modifier: Modifier = Modifier,
    animalPhotoRes: Int,
    animalPhotoContentDescription: String,
) {
    Image(
        ImageBitmap.imageResource(id = animalPhotoRes),
        contentDescription = animalPhotoContentDescription,
        modifier = modifier
            .aspectRatio(1f)
            .padding(4.dp),
        contentScale = ContentScale.Crop
    )
}