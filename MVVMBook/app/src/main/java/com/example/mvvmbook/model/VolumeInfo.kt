package com.example.mvvmbook.model

data class VolumeInfo(
    val title: String,
    val subtitle: String,
    val authors: Array<String>,
    val publishedDate: String,
    val description: String,
    val pageCount: Int,
    val categories: String
)