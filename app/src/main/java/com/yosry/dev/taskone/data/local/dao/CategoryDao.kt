package com.yosry.dev.taskone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yosry.dev.taskone.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categories: List<CategoryEntity>)

    @Query("SELECT * FROM categories")
    fun getAllCategories(): Flow<List<CategoryEntity>>

    @Query("DELETE FROM categories")
    suspend fun clearAll()

    // We might also want a way to get a single category by its categoryId,
    // though the API usually provides lists. For now, we'll keep it simple.
    // @Query("SELECT * FROM categories WHERE categoryId = :categoryId")
    // fun getCategoryById(categoryId: String): Flow<CategoryEntity?>
}
