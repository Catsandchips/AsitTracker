package com.android.slouchingdog.slouchyasit.data.di

import com.android.slouchingdog.slouchyasit.data.local.IntakeDAO
import com.android.slouchingdog.slouchyasit.data.local.IntakeRepositoryImpl
import com.android.slouchingdog.slouchyasit.domain.repository.IntakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepositoryImpl(dao: IntakeDAO): IntakeRepository {
        return IntakeRepositoryImpl(dao)
    }
}