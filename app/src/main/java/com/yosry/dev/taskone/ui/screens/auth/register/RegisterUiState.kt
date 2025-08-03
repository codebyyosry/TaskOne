package com.yosry.dev.taskone.ui.screens.auth.register

import com.yosry.dev.taskone.ui.core.UiStatus

data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val age: Int = 0,
    val gender: String = "",
    val phoneNumber: String = "",
    val status: UiStatus = UiStatus.Idle

)