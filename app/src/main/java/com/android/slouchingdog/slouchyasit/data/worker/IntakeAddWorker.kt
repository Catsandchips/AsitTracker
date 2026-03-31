package com.android.slouchingdog.slouchyasit.data.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.android.slouchingdog.slouchyasit.data.toTimestamp
import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import com.android.slouchingdog.slouchyasit.domain.use_cases.AddIntakeUseCase
import com.android.slouchingdog.slouchyasit.domain.use_cases.GetIntakeByDateUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.UUID

@HiltWorker
class IntakeAddWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val addIntakeUseCase: AddIntakeUseCase,
    private val getIntakeByDateUseCase: GetIntakeByDateUseCase

) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        return@withContext try {
            getIntakeByDateUseCase(LocalDate.now().toTimestamp()).collect {
                if (it == null) {
                    val intake = IntakeEntity(
                        id = UUID.randomUUID().toString(),
                        isTaken = false,
                        intakeDate = LocalDate.now(),
                        dosage = "300ИР",
                        dropsNumber = 3,
                    )
                    addIntakeUseCase(intake)
                }
            }
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.retry()
        }
    }
}