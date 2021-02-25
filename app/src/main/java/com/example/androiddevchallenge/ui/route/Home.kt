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

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.Animal
import com.example.androiddevchallenge.data.animals
import com.example.androiddevchallenge.ui.component.AnimalCard
import dev.chrisbanes.accompanist.insets.statusBarsHeight

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background
    ) { innerPadding ->
        ToBeAdoptList(
            modifier = Modifier.padding(innerPadding),
            animals = animals,
            onAnimalClick = {
                navController.navigate("detail/${it.name}")
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ToBeAdoptList(
    modifier: Modifier = Modifier,
    animals: List<Animal>,
    onAnimalClick: (Animal) -> Unit
) {
    val column = 2
    LazyVerticalGrid(modifier = modifier, cells = GridCells.Fixed(column)) {
        repeat(column) {
            item { Spacer(modifier = Modifier.statusBarsHeight()) }
        }
        items(animals) { animal ->
            Column {
                Text(animal.name)
                AnimalCard(
                    modifier = Modifier.clickable { onAnimalClick(animal) },
                    animalPhotoRes = animal.imageRes,
                    animalPhotoContentDescription = animal.name
                )
            }
        }
    }
}
