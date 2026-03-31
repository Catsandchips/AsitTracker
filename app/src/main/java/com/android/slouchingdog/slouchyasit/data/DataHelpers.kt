package com.android.slouchingdog.slouchyasit.data

import java.time.LocalDate
import java.time.ZoneId

fun LocalDate.toTimestamp() = this.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()