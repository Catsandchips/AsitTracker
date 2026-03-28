package com.android.slouchingdog.slouchyasit.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import java.time.LocalDate

const val TABLE_NAME = "intakes"
typealias IntakeDBOList = List<IntakeDBO>


@Entity(tableName = TABLE_NAME)
data class IntakeDBO(
    @PrimaryKey
    val id: String,
    val isTaken: Boolean,
    val intakeDate: LocalDate,
    val dosage: String,
    val dropsNumber: Int
)

fun IntakeDBO.mapToIntakeEntity() = IntakeEntity(
    id = id,
    isTaken = isTaken,
    intakeDate = intakeDate,
    dosage = dosage,
    dropsNumber = dropsNumber
)

fun IntakeDBOList.mapToIntakeEntityList() = map { it.mapToIntakeEntity() }