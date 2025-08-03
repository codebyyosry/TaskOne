package com.yosry.dev.taskone.ui.screens.auth.login

import com.yosry.dev.taskone.ui.core.UiStatus

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val status: UiStatus = UiStatus.Idle

)