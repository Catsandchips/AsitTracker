package com.android.slouchingdog.slouchyasit.domain.use_cases

import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import com.android.slouchingdog.slouchyasit.domain.repository.IntakeRepository
import kotlinx.coroutines.flow.Flow

class GetIntakeListUseCase(private val intakeRepository: IntakeRepository) {
    suspend operator fun invoke(): Flow<List<IntakeEntity>> {
        return intakeRepository.getIntakes()
    }
}