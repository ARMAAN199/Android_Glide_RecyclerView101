package com.example.wallpaperapp

data class ImagesResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)