package com.yosry.dev.taskone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yosry.dev.taskone.data.local.entity.AreaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AreaDao {

    /**
     * Inserts a list of areas into the database. If a conflict occurs (e.g., an area
     * with the same auto-generated id already exists, which is unlikely if you always
     * clear first or are inserting new data), it replaces the old data.
     *
     * Consider clearing the table before inserting a fresh list from the API if you
     * don't need to merge data.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(areas: List<AreaEntity>)

    /**
     * Inserts a single area.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(area: AreaEntity)

    /**
     * Retrieves all areas from the database, ordered by name.
     * Returns a Flow, so UI can observe changes automatically.
     */
    @Query("SELECT * FROM areas ORDER BY name ASC")
    fun getAllAreas(): Flow<List<AreaEntity>>

    /**
     * Retrieves an area by its name.
     * Note: Area names should ideally be unique if you query by them often.
     * If names are not unique, this will return the first one found.
     */
    @Query("SELECT * FROM areas WHERE name = :name LIMIT 1")
    suspend fun getAreaByName(name: String): AreaEntity?

    /**
     * Deletes all areas from the database.
     */
    @Query("DELETE FROM areas")
    suspend fun clearAll()
}
