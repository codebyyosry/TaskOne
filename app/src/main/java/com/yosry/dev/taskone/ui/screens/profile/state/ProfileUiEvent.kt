package com.yosry.dev.taskone.ui.screens.profile.state

sealed class ProfileUiEvent {
    data class NameChanged(val name: String) : ProfileUiEvent()
    data class EmailChanged(val email: String) : ProfileUiEvent()
    data class AgeChanged(val age: Int) : ProfileUiEvent()
    data class GenderChanged(val gender: String) : ProfileUiEvent()
    data class PhoneNumberChanged(val phoneNumber: String) : ProfileUiEvent()
    data class AvatarUriChanged(val avatarUri: String) : ProfileUiEvent()
    object Save : ProfileUiEvent()
    object Cancel : ProfileUiEvent()
    object Update : ProfileUiEvent()
    object Logout : ProfileUiEvent()
    object NavigateBack : ProfileUiEvent()
    object NavigateToSettings : ProfileUiEvent()
    object UpdatePassword : ProfileUiEvent()
}