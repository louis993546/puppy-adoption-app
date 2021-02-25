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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.glide.GlideImage
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.statusBarsHeight
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets {
                MyTheme {
                    MyApp()
                }
            }
        }
    }
}

@Immutable
data class Animal(
    val name: String,
    val imageRes: Int,
)

@Composable
fun AnimalCard(
    modifier: Modifier = Modifier,
    animalPhotoRes: Int,
    animalPhotoContentDescription: String,
) {
    GlideImage(
        modifier = modifier
            .aspectRatio(1f)
            .padding(4.dp),
        data = animalPhotoRes,
        contentDescription = animalPhotoContentDescription,
        contentScale = ContentScale.Crop,
        fadeIn = true,
        error = { e ->
            Timber.e(e.throwable)
            Text("🙅‍")
        }
    )
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

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { Home(navController = navController) }
        composable("detail/{animalName}") { backStackEntry -> 
            Detail(animal = getAnimalByName(backStackEntry.arguments?.getString("animalName")))
        }
    }
}

fun getAnimalByName(name: String?): Animal = animals.first { it.name == name }

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

@Composable
fun Detail(
    modifier: Modifier = Modifier,
    animal: Animal,
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.statusBarsHeight())
        GlideImage(
            modifier = modifier,
            data = animal.imageRes,
            contentDescription = animal.name,
            fadeIn = true,
            error = { e ->
                Timber.e(e.throwable)
                Text("🙅‍")
            }
        )
    }
}

val animals = listOf(
    Animal(
        name = "TBD 1",
        imageRes = R.drawable.dog1,
    ),
    Animal(
        name = "TBD 2",
        imageRes = R.drawable.dog2,
    ),
    Animal(
        name = "TBD 3",
        imageRes = R.drawable.dog3,
    ),
    Animal(
        name = "TBD 4",
        imageRes = R.drawable.dog4,
    ),
    Animal(
        name = "TBD 5",
        imageRes = R.drawable.dog5,
    ),
    Animal(
        name = "TBD 6",
        imageRes = R.drawable.dog6,
    )
)

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
