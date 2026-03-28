package com.android.slouchingdog.slouchyasit.presentation.screens.intake_journal

import androidx.lifecycle.ViewModel
import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class IntakeJournalViewModel : ViewModel() {
    private val _intakesList: MutableStateFlow<List<IntakeEntity>> =
        MutableStateFlow(listOf())
    val intakesList = _intakesList.asStateFlow()

    init {
        _intakesList.update {
            listOf(

            )
        }
    }
}
