package com.android.slouchingdog.slouchyasit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.slouchingdog.slouchyasit.data.local.entities.DateTypeConverters
import com.android.slouchingdog.slouchyasit.data.local.entities.IntakeDBO

@Database(entities = [IntakeDBO::class], version = 1)
@TypeConverters(DateTypeConverters::class)
abstract class IntakeDatabase : RoomDatabase() {
    abstract fun intakeDao(): IntakeDAO
}