package com.yosry.dev.taskone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yosry.dev.taskone.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    /**
     * Inserts a user into the table. If the user already exists, it replaces the existing entry.
     * This effectively saves or updates the current user.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceUser(user: UserEntity)

    /**
     * Retrieves the single user profile stored.
     * Returns a Flow so the UI can observe changes.
     * It will emit null if no user is stored.
     */
    @Query("SELECT * FROM users LIMIT 1")
    fun getCurrentUser(): Flow<UserEntity?>

    /**
     * Deletes all users from the table.
     * Since we only store one user, this effectively deletes the current user.
     */
    @Query("DELETE FROM users")
    suspend fun deleteCurrentUser()
}