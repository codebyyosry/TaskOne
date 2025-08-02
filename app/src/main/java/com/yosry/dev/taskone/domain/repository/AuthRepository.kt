package com.yosry.dev.taskone.domain.repository

interface AuthRepository {
    suspend fun login()
    suspend fun register()
    suspend fun resetPassword()
    suspend fun logout()
    suspend fun verifyEmail()
    suspend fun verifyOTP()
    suspend fun deleteAccount()
}