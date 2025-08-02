package com.yosry.dev.taskone.ui.screens.profile.state

import com.yosry.dev.taskone.domain.model.User

data class ProfileUiState(
    val user: User? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
