package com.yosry.dev.taskone.ui.screens.auth.forgetpass

import com.yosry.dev.taskone.ui.core.UiStatus

data class ForgotPasswordUiState(
    val email: String = "",
    val status: UiStatus = UiStatus.Idle
)
