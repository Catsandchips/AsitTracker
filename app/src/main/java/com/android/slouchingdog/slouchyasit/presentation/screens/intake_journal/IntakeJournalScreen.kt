package com.android.slouchingdog.slouchyasit.presentation.screens.intake_journal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.android.slouchingdog.slouchyasit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntakeJournalScreen(onIntakeRowClick: (String) -> Unit) {
    val viewModel: IntakeJournalViewModel = hiltViewModel()
    val intakeJournalState: IntakeJournalState by viewModel.intakeJournalState.collectAsState()

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("Журнал приема") }) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(intakeJournalState.intakeList) {intake ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = {
                            onIntakeRowClick(intake.id)
                        })
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${intake.intakeDate}")
                    Text(intake.dosage)
                    Text("${intake.dropsNumber} капли")
                    if (intake.isTaken) {
                        Icon(
                            painter = painterResource(R.drawable.check_24px),
                            tint = Color.Green,
                            contentDescription = "'Is taken' icon"
                        )

                    } else {
                        Icon(
                            painter = painterResource(R.drawable.close_24px),
                            tint = Color.Red,
                            contentDescription = "'Is not taken' icon"
                        )
                    }
                }
                Spacer(Modifier.height(8.dp))
                HorizontalDivider(thickness = 2.dp)
            }
        }

    }
}