/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.route

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun Others(
    modifier: Modifier = Modifier,
    launchWebsite: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
    ) {
        item { Spacer(modifier = Modifier.statusBarsHeight()) }
        item {
            Text(
                "Thank you to the following photographers 🤗",
                modifier = Modifier.padding(4.dp)
                    .fillMaxWidth(),
            )
        }
        items(photosFrom, key = { it.url }) { photoFrom ->
            PhotoCard(
                modifier = Modifier.padding(vertical = 4.dp),
                photoFrom = photoFrom,
                launchWebsite = launchWebsite
            )
        }
    }
}

@Composable
fun PhotoCard(
    modifier: Modifier = Modifier,
    photoFrom: PhotoFrom,
    launchWebsite: (String) -> Unit,
) {
    Card(
        modifier = modifier.clickable { launchWebsite(photoFrom.url) },
        elevation = 4.dp,
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = photoFrom.name
        )
    }
}

data class PhotoFrom(
    val url: String,
    val name: String,
)

private val photosFrom = listOf(
    PhotoFrom("https://unsplash.com/@oddityandgrace?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "hannah grace"),
    PhotoFrom("https://unsplash.com/@berkaygumustekin?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Berkay Gumustekin"),
    PhotoFrom("https://unsplash.com/@erinw?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Erin Minuskin"),
    PhotoFrom("https://unsplash.com/@annadudkova?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Anna Dudkova"),
    PhotoFrom("https://unsplash.com/@bk010397?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Bharathi Kannan"),
    PhotoFrom("https://unsplash.com/@wannesdemol?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Wannes De Mol"),
    PhotoFrom("https://unsplash.com/@jorgezapatag?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Jorge Zapata"),
    PhotoFrom("https://unsplash.com/@dstaton?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Dale Staton"),
    PhotoFrom("https://unsplash.com/@kindredhues?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Kindred Hues Photography"),
    PhotoFrom("https://unsplash.com/@ivanana?utm_source=unsplash&amp;utm_medium=referral&amp;utm_content=creditCopyText", "Ivana La"),
)
