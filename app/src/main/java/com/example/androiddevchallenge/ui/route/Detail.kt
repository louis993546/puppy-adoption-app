package com.example.androiddevchallenge.ui.route

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import com.example.androiddevchallenge.data.Animal
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun Detail(
    modifier: Modifier = Modifier,
    animal: Animal,
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.statusBarsHeight())
        Image(
            bitmap = ImageBitmap.imageResource(id = animal.imageRes),
            contentDescription = animal.name,
            modifier = modifier,
        )
    }
}