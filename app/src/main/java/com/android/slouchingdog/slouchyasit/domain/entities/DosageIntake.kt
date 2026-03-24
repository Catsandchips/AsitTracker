package com.android.slouchingdog.slouchyasit.domain.entities

import java.time.LocalDate

data class DosageIntakeEntity(
    val isTaken: Boolean,
    val date: LocalDate,
    val dosage: String,
    val dropsNumber: Int
)