package com.android.slouchingdog.slouchyasit.domain.use_cases

import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import com.android.slouchingdog.slouchyasit.domain.repository.IntakeRepository


class AddIntakeUseCase(private val intakeRepository: IntakeRepository) {
    suspend operator fun invoke(intakeEntity: IntakeEntity) {
        intakeRepository.addIntake(intakeEntity)
    }
}