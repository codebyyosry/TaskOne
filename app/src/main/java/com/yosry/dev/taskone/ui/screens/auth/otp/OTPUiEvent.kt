package com.yosry.dev.taskone.ui.screens.auth.otp

sealed class OTPUiEvent {
    data class OtpChanged(val otp: Int) : OTPUiEvent()
    object Verify : OTPUiEvent()
}