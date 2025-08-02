package com.yosry.dev.taskone.ui.screens.auth.forgetpass

data class ForgotPasswordUiState(
    val email: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = null
)
