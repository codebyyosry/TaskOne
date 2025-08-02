package com.yosry.dev.taskone.ui.screens.auth.register

data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val age: Int = 0,
    val gender: String = "",
    val phoneNumber: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
)