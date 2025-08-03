package com.yosry.dev.taskone.data.remote.dto

data class MealsResponse(
    val meals: List<MealDto>? // Meals can be null if no results
)