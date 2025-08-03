package com.yosry.dev.taskone.data.repository

import com.yosry.dev.taskone.data.local.dao.UserDao
import com.yosry.dev.taskone.data.local.entity.toDomain
import com.yosry.dev.taskone.data.local.entity.toEntity
import com.yosry.dev.taskone.domain.model.User
import com.yosry.dev.taskone.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton // Typically repositories are singletons
class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
    // private val userApiService: UserApiService // If fetching user data from network
) : UserRepository {

    override fun getCurrentUser(): Flow<User?> {
        return userDao.getCurrentUser().map { it?.toDomain() }
    }

    override suspend fun saveUser(user: User) {
        // You have User.toEntity() in UserEntity.kt
        userDao.insertOrReplaceUser(user.toEntity())
    }

    override suspend fun clearUserData() {
        userDao.deleteCurrentUser()

    }
}