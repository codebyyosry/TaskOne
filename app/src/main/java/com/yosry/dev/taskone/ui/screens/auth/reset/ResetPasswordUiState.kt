package com.yosry.dev.taskone.ui.screens.auth.reset

data class ResetPasswordUiState(
    val oldPassword: String,
    val password: String,
    val confirmPassword: String,
    val isLoading: Boolean,
    val isSuccess: Boolean,
    val isError: Boolean,
    val errorMessage: String?
)
