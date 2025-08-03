package com.yosry.dev.taskone.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoryListResponse(
    @SerializedName("meals")
    val categories: List<SimpleCategoryDto> // The API returns "meals" array for this
)