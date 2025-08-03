package com.yosry.dev.taskone.domain.model

data class Category(
    val name: String,
    val thumbnailUrl: String? = null // if categories have images
)
