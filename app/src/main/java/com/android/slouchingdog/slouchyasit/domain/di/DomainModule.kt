package com.android.slouchingdog.slouchyasit.domain.di

import com.android.slouchingdog.slouchyasit.domain.repository.IntakeRepository
import com.android.slouchingdog.slouchyasit.domain.use_cases.AddIntakeUseCase
import com.android.slouchingdog.slouchyasit.domain.use_cases.GetIntakeByDateUseCase
import com.android.slouchingdog.slouchyasit.domain.use_cases.GetIntakeByIdUseCase
import com.android.slouchingdog.slouchyasit.domain.use_cases.GetIntakeListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun provideAddIntakeUseCase(intakeRepository: IntakeRepository): AddIntakeUseCase {
        return AddIntakeUseCase(intakeRepository)
    }

    @Provides
    fun provideGetIntakeByIdUseCase(intakeRepository: IntakeRepository): GetIntakeByIdUseCase {
        return GetIntakeByIdUseCase(intakeRepository)
    }

    @Provides
    fun provideGetIntakeListUseCase(intakeRepository: IntakeRepository): GetIntakeListUseCase {
        return GetIntakeListUseCase(intakeRepository)
    }

    @Provides
    fun provideGetIntakeByDateUseCase(intakeRepository: IntakeRepository): GetIntakeByDateUseCase {
        return GetIntakeByDateUseCase(intakeRepository)
    }
}