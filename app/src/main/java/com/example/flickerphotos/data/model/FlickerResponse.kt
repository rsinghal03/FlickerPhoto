package com.example.flickerphotos.data.model

data class FlickerResponse(
    val description: String,
    val generator: String,
    val items: List<Item>,
    val link: String,
    val modified: String,
    val title: String
)