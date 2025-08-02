package com.yosry.dev.taskone.ui.screens.auth.login

sealed class LoginUiEvent {
    data class EmailChanged(val email: String) : LoginUiEvent()
    data class PasswordChanged(val password: String) : LoginUiEvent()
    object Login : LoginUiEvent()
}