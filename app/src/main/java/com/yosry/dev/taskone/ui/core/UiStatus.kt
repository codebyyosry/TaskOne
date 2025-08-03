package com.yosry.dev.taskone.ui.core

sealed class UiStatus {
    object Idle : UiStatus()
    object Loading : UiStatus()
    object Success : UiStatus()
    data class Error(val message: String) : UiStatus()
}


/*

when (uiState.status) {
    is UiStatus.Idle -> { /* show nothing */ }
    is UiStatus.Loading -> { /* show progress bar */ }
    is UiStatus.Success -> { /* show success UI */ }
    is UiStatus.Error -> {
        val message = (uiState.status as UiStatus.Error).message
        // show error message
    }
}
 */