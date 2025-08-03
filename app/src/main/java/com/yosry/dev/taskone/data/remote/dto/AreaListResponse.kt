package com.yosry.dev.taskone.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AreaListResponse(
    @SerializedName("meals")
    val areas: List<SimpleAreaDto> // The API returns "meals" array for this
)