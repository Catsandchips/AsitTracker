package com.android.slouchingdog.slouchyasit.presentation.screens.intake_journal

import androidx.lifecycle.ViewModel
import com.android.slouchingdog.slouchyasit.domain.entities.DosageIntakeEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

class IntakeJournalViewModel : ViewModel() {
    private val _intakesList: MutableStateFlow<List<DosageIntakeEntity>> =
        MutableStateFlow(listOf())
    val intakesList = _intakesList.asStateFlow()

    init {
        _intakesList.update {
            listOf(
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
                DosageIntakeEntity(true, LocalDate.now(), "30ИР", 3),
                DosageIntakeEntity(false, LocalDate.now(), "3000ИР", 3),
            )
        }
    }
}
