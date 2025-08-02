package com.yosry.dev.taskone.domain.repository

interface ProfileRepository {
    suspend fun loadProfile()
    suspend fun updateProfile()
    suspend fun deleteProfile()
}