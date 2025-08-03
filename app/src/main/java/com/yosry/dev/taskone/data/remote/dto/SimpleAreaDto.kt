package com.yosry.dev.taskone.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SimpleAreaDto(
    @SerializedName("strArea")
    val name: String
)