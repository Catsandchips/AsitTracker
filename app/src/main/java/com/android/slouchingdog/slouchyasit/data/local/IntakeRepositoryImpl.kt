package com.android.slouchingdog.slouchyasit.data.local

import com.android.slouchingdog.slouchyasit.data.local.entities.mapToIntakeEntity
import com.android.slouchingdog.slouchyasit.data.local.entities.mapToIntakeEntityList
import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import com.android.slouchingdog.slouchyasit.domain.entities.mapToIntakeDBO
import com.android.slouchingdog.slouchyasit.domain.repository.IntakeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class IntakeRepositoryImpl(private val intakeDAO: IntakeDAO) : IntakeRepository {
    override suspend fun getIntakes(): Flow<List<IntakeEntity>> {
        return intakeDAO.getAllIntakes().map { it.mapToIntakeEntityList() }
    }

    override suspend fun getIntakeById(id: String): IntakeEntity {
        return intakeDAO.getIntakeById(id).mapToIntakeEntity()
    }

    override suspend fun addIntake(intakeEntity: IntakeEntity) {
        intakeDAO.addIntake(intakeEntity.mapToIntakeDBO())
    }
}