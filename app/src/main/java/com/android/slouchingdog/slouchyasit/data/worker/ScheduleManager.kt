package com.android.slouchingdog.slouchyasit.data.worker

import android.icu.util.Calendar
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ScheduleManager @Inject constructor(private val workManager: WorkManager) {

    fun scheduleDailyIntakeCreation() {
        val now = Calendar.getInstance()
        val nextRun = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            if (this.before(now)) {
                add(Calendar.DAY_OF_MONTH, 1)
            }
        }

        val initialDelay = nextRun.timeInMillis - now.timeInMillis

        val dailyWorkRequest = PeriodicWorkRequestBuilder<IntakeAddWorker>(
            24, TimeUnit.HOURS, 15,
            TimeUnit.MINUTES
        )
            .setInitialDelay(initialDelay, TimeUnit.MICROSECONDS)
            .build()

        workManager.enqueueUniquePeriodicWork(
            "daily_intake_creation",
            ExistingPeriodicWorkPolicy.UPDATE,
            dailyWorkRequest
        )
    }
}