package com.example.app1jetpackcompose

data class CardItem(
    val title: String,
    val id: Int,
    val imageRes: Int,
    val population: String,
    val region: String,
    val description: String,
    var likes: Int = 0,
    val latin: String,
    val weight: String,
    val height: String
    )
