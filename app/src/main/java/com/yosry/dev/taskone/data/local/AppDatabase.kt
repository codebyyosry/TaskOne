package com.yosry.dev.taskone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yosry.dev.taskone.data.local.dao.AreaDao
import com.yosry.dev.taskone.data.local.dao.CategoryDao
import com.yosry.dev.taskone.data.local.dao.UserDao
import com.yosry.dev.taskone.data.local.entity.AreaEntity
import com.yosry.dev.taskone.data.local.entity.CategoryEntity
import com.yosry.dev.taskone.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        CategoryEntity::class,
        AreaEntity::class
    ],
    version = 1, // Start with version 1. Increment if you change the schema later.
    exportSchema = false // Recommended to set to true for production apps for schema migration history
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun areaDao(): AreaDao

    abstract fun categoryDao(): CategoryDao
    // DAOs will be declared here later
    // abstract fun userDao(): UserDao
    // abstract fun categoryDao(): CategoryDao

    companion object {
        // You'll typically have a singleton instance logic here, often using Hilt.
        // For now, we'll leave it simple. Hilt will handle providing it.
        const val DATABASE_NAME = "task_one_db"
    }
}
