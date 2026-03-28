package com.android.slouchingdog.slouchyasit.domain.use_cases

import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import com.android.slouchingdog.slouchyasit.domain.repository.IntakeRepository

class GetIntakeByIdUseCase(private val intakeRepository: IntakeRepository) {
    suspend operator fun invoke(id: String): IntakeEntity {
        return intakeRepository.getIntakeById(id)
    }
}