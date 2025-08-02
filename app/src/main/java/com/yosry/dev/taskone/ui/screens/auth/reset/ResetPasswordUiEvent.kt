package com.yosry.dev.taskone.ui.screens.auth.reset

sealed class ResetPasswordUiEvent {
    data class PasswordChanged(val password: String) : ResetPasswordUiEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String) : ResetPasswordUiEvent()
    object ResetPassword : ResetPasswordUiEvent()
}