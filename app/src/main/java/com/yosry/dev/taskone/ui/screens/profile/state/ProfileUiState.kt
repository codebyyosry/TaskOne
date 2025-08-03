package com.yosry.dev.taskone.ui.screens.profile.state

import com.yosry.dev.taskone.domain.model.User
import com.yosry.dev.taskone.ui.core.UiStatus

data class ProfileUiState(
    val user: User? = null,
    val status: UiStatus = UiStatus.Idle
)
