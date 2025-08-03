package com.yosry.dev.taskone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val categoryId: String,
    val name: String,
    val thumbnailUrl: String,
    val description: String
)