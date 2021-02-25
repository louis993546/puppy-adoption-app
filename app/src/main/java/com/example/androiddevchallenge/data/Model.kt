package com.example.androiddevchallenge.data

import androidx.compose.runtime.Immutable

@Immutable
data class Animal(
    val name: String,
    val imageRes: Int,
)