package com.android.slouchingdog.slouchyasit.data.local.entities

import androidx.room.TypeConverter
import com.android.slouchingdog.slouchyasit.data.toTimestamp
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class DateTypeConverters {
    @TypeConverter
    fun fromTimestamp(timestamp: Long): LocalDate {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate()
    }

    @TypeConverter
    fun toTimestamp(localDate: LocalDate): Long {
        return localDate.toTimestamp()
    }
}