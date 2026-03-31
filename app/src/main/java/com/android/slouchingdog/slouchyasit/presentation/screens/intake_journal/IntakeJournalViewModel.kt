package com.android.slouchingdog.slouchyasit.presentation.screens.intake_journal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import com.android.slouchingdog.slouchyasit.domain.use_cases.GetIntakeListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntakeJournalViewModel @Inject constructor(val getIntakeListUseCase: GetIntakeListUseCase) :
    ViewModel() {
    private val _intakesList: MutableStateFlow<List<IntakeEntity>> =
        MutableStateFlow(listOf())
    val intakesList = _intakesList.asStateFlow()

    init {
        viewModelScope.launch {
            getIntakeListUseCase().collect {
                _intakesList.update { it }
            }
        }
    }
}
