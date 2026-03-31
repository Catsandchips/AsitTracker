package com.android.slouchingdog.slouchyasit.presentation.screens.intake_tracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import com.android.slouchingdog.slouchyasit.domain.use_cases.AddIntakeUseCase
import com.android.slouchingdog.slouchyasit.domain.use_cases.GetIntakeByIdUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

@HiltViewModel(assistedFactory = IntakeTrackerViewModel.IntakeTrackerViewModelFactory::class)
class IntakeTrackerViewModel @AssistedInject constructor(
    @Assisted val id: String,
    val getIntakeByIdUseCase: GetIntakeByIdUseCase,
    val addIntakeUseCase: AddIntakeUseCase
) : ViewModel() {
    @AssistedFactory
    interface IntakeTrackerViewModelFactory {
        fun create(id: String): IntakeTrackerViewModel
    }

    private val _trackerState: MutableStateFlow<IntakeTrackerState> =
        MutableStateFlow(IntakeTrackerState())
    val trackerState = _trackerState.asStateFlow()

    init {
        viewModelScope.launch {
            getIntakeByIdUseCase(id).collect { intake ->
                if (intake != null) {
                    _trackerState.update {
                        it.copy(
                            isTaken = intake.isTaken,
                            date = intake.intakeDate,
                            dosage = intake.dosage,
                            dropsNumber = intake.dropsNumber
                        )
                    }
                }
            }
        }
    }

    fun onDoseTakeChange() {
        _trackerState.update { it.copy(isTaken = !it.isTaken) }
        viewModelScope.launch {
            val state = trackerState.value
            addIntakeUseCase(
                IntakeEntity(
                    id = id,
                    isTaken = state.isTaken,
                    intakeDate = state.date,
                    dosage = state.dosage,
                    dropsNumber = state.dropsNumber
                )
            )
        }
    }
}

data class IntakeTrackerState(
    val isTaken: Boolean = false,
    val date: LocalDate = LocalDate.now(),
    val dosage: String = "3000",
    val dropsNumber: Int = 3
)