package com.yosry.dev.taskone.domain.model

data class Meal(
    val id: String,
    val name: String,
    val thumbnailUrl: String?,
    val category: String, // Or you could embed a Category object if useful
    val area: String,     // Or an Area object
    val instructions: String?,
    val ingredients: List<IngredientMeasurement> = emptyList(),
    val youtubeUrl: String? = null,
    val tags: List<String> = emptyList()
)

data class IngredientMeasurement(
    val ingredient: String,
    val measure: String
)
