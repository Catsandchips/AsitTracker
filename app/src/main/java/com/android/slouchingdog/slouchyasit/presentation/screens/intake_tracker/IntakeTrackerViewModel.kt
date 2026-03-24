package com.android.slouchingdog.slouchyasit.presentation.screens.intake_tracker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

class IntakeTrackerViewModel : ViewModel() {
    private val _trackerState: MutableStateFlow<IntakeTrackerState> =
        MutableStateFlow(IntakeTrackerState())
    val trackerState = _trackerState.asStateFlow()

    fun onDoseTakeChange() {
        _trackerState.update { it.copy(isTaken = !it.isTaken) }
    }

}

data class IntakeTrackerState(
    val isTaken: Boolean = false,
    val date: LocalDate = LocalDate.now(),
    val dosage: String = "3000",
    val dropsNumber: Int = 3
)