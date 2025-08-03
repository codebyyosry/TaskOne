package com.yosry.dev.taskone.ui.screens.auth.forgetpass

sealed class ForgetPasswordUiEvent {
    data class EmailChanged(val email: String) : ForgetPasswordUiEvent()
    object ForgetPassword : ForgetPasswordUiEvent()


}
