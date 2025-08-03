package com.yosry.dev.taskone.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SimpleCategoryDto(
    @SerializedName("strCategory")
    val name: String
)
