package com.android.slouchingdog.slouchyasit.domain.entities

import java.time.LocalTime

data class DosageSettings(
    val dosage: String,
    val dropsNumber: Int,
    val intakeTime: LocalTime
)