package com.android.slouchingdog.slouchyasit.domain.entities

import com.android.slouchingdog.slouchyasit.data.local.entities.IntakeDBO
import java.time.LocalDate

typealias IntakeEntityList = List<IntakeEntity>

data class IntakeEntity(
    val id: String,
    val isTaken: Boolean,
    val intakeDate: LocalDate,
    val dosage: String,
    val dropsNumber: Int
)

fun IntakeEntity.mapToIntakeDBO() = IntakeDBO(
    id = id,
    isTaken = isTaken,
    intakeDate = intakeDate,
    dosage = dosage,
    dropsNumber = dropsNumber
)

fun IntakeEntityList.mapToIntakeDBOList() = map { it.mapToIntakeDBO() }