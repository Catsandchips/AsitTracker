package com.android.slouchingdog.slouchyasit.domain.repository

import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import kotlinx.coroutines.flow.Flow

interface IntakeRepository {
    suspend fun getIntakes(): Flow<List<IntakeEntity>>
    suspend fun getIntakeById(id: String): IntakeEntity
    suspend fun addIntake(intakeEntity: IntakeEntity)
}