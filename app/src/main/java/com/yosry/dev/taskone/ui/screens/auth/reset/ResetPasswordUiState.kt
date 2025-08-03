package com.yosry.dev.taskone.ui.screens.auth.reset

import com.yosry.dev.taskone.ui.core.UiStatus

data class ResetPasswordUiState(
    val oldPassword: String,
    val password: String,
    val confirmPassword: String,
    val status: UiStatus = UiStatus.Idle

)
