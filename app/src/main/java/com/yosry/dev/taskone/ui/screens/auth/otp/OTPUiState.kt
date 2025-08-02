package com.yosry.dev.taskone.ui.screens.auth.otp

data class OTPUiState(
    val otp: Int,
    val isLoading: Boolean,
    val isSuccess: Boolean,
    val isError: Boolean,
    val errorMessage: String?
)