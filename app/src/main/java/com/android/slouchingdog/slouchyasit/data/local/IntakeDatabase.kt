package com.android.slouchingdog.slouchyasit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.slouchingdog.slouchyasit.data.local.entities.IntakeDBO

@Database(entities = [IntakeDBO::class], version = 1)
abstract class IntakeDatabase : RoomDatabase() {
    abstract fun intakeDao(): IntakeDAO
}