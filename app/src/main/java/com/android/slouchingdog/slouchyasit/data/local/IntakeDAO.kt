package com.android.slouchingdog.slouchyasit.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.android.slouchingdog.slouchyasit.data.local.entities.IntakeDBO
import com.android.slouchingdog.slouchyasit.data.local.entities.TABLE_NAME
import kotlinx.coroutines.flow.Flow


@Dao
interface IntakeDAO {
    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun getIntakeById(id: String): IntakeDBO

    @Query("SELECT * FROM $TABLE_NAME ORDER BY intakeDate DESC")
    suspend fun getAllIntakes(): Flow<List<IntakeDBO>>

    @Insert(onConflict = REPLACE)
    suspend fun addIntake(intakeDBO: IntakeDBO)
}