package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

fun getAnimalByName(name: String?): Animal = animals.first { it.name == name }

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
    ),
    Animal(
        name = "TBD 7",
        imageRes = R.drawable.dog7,
    ),
    Animal(
        name = "TBD 8",
        imageRes = R.drawable.dog8,
    ),
    Animal(
        name = "TBD 9",
        imageRes = R.drawable.dog9,
    ),
    Animal(
        name = "TBD 10",
        imageRes = R.drawable.dog10,
    ),
    Animal(
        name = "TBD 11",
        imageRes = R.drawable.dog11,
    )
)
