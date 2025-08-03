package com.yosry.dev.taskone.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val thumbnailUrl: String,
    @SerializedName("strCategoryDescription")
    val description: String
)
