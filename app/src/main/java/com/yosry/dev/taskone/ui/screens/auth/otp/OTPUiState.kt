package com.yosry.dev.taskone.ui.screens.auth.otp

import com.yosry.dev.taskone.ui.core.UiStatus

data class OTPUiState(
    val otp: Int,
    val status: UiStatus = UiStatus.Idle
)