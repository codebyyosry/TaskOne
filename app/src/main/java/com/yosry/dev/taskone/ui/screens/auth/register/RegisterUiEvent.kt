package com.yosry.dev.taskone.ui.screens.auth.register

sealed class RegisterUiEvent {
    data class NameChanged(val name: String) : RegisterUiEvent()
    data class EmailChanged(val email: String) : RegisterUiEvent()
    data class PasswordChanged(val password: String) : RegisterUiEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String) : RegisterUiEvent()
    data class AgeChanged(val age: Int) : RegisterUiEvent()
    data class GenderChanged(val gender: String) : RegisterUiEvent()
    data class PhoneNumberChanged(val phoneNumber: String) : RegisterUiEvent()
    object Verify : RegisterUiEvent()
    object Register : RegisterUiEvent()

}