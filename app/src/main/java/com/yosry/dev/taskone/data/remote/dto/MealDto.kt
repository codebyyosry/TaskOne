package com.yosry.dev.taskone.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MealDto(
    @SerializedName("idMeal")
    val id: String,
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strDrinkAlternate")
    val drinkAlternate: String?,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strArea")
    val area: String,
    @SerializedName("strInstructions")
    val instructions: String,
    @SerializedName("strMealThumb")
    val thumbnailUrl: String,
    @SerializedName("strTags")
    val tags: String?,
    @SerializedName("strYoutube")
    val youtubeUrl: String?,
    @SerializedName("dateModified") // Assuming 'dateModified' is the actual key in JSON
    val dateModified: String?
)
