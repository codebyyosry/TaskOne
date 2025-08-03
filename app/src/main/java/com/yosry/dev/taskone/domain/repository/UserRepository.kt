package com.yosry.dev.taskone.domain.repository

import com.yosry.dev.taskone.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getCurrentUser(): Flow<User?> // Get the current user, null if not logged in/no data

    suspend fun saveUser(user: User) // Save or update user data

    suspend fun clearUserData() // Clear user data (e.g., on logout)
}
