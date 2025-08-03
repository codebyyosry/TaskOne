package com.yosry.dev.taskone.ui.screens.browse

import com.yosry.dev.taskone.domain.model.Area
import com.yosry.dev.taskone.domain.model.Category

data class BrowseUiState(
    val categories: List<Category> = emptyList(),
    val areas: List<Area> = emptyList(),
    val isLoadingCategories: Boolean = false,
    val isLoadingAreas: Boolean = false,
    val error: String? = null // Or a more specific error type
)