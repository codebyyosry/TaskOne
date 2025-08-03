package com.yosry.dev.taskone.domain.model

/**
 * A lighter version of a Meal, suitable for displaying in lists.
 */
data class MealItem(
    val id: String,
    val name: String,
    val thumbnailUrl: String?
)
