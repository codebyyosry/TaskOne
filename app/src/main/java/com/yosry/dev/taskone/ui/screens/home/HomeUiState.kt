package com.yosry.dev.taskone.ui.screens.home

data class HomeUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isSuccess: Boolean = false,
)
