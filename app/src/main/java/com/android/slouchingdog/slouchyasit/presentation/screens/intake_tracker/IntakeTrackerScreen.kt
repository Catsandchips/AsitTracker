package com.android.slouchingdog.slouchyasit.presentation.screens.intake_tracker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.android.slouchingdog.slouchyasit.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntakeTrackerScreen(id: String, onBackButtonClick: () -> Unit) {
    val viewModel =
        hiltViewModel<IntakeTrackerViewModel, IntakeTrackerViewModel.IntakeTrackerViewModelFactory>(
            creationCallback = { it.create(id) }
        )
    val trackerState: IntakeTrackerState by viewModel.trackerState.collectAsState()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Сталораль Береза"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackButtonClick() }) {
                        Icon(
                            painter = painterResource(R.drawable.arrow_back_24px),
                            contentDescription = "Menu button"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.settings_24px),
                                contentDescription = "Edit course"
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                if (trackerState.isTaken) {
                    Text("Сегодняшняя доза принята!", style = MaterialTheme.typography.titleLarge)

                } else {
                    Row {
                        Text(
                            text = "Дата: ",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "${trackerState.date}",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    Row {
                        Text(
                            text = "Дозировка: ",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "${trackerState.dosage}ИР",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    Row {
                        Text(
                            text = "Количество капель: ",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "${trackerState.dropsNumber}",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }

                Spacer(modifier = Modifier.height(64.dp))

                Button(
                    onClick = {
                        viewModel.onDoseTakeChange()
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    val buttonText = if (trackerState.isTaken) "Отмена" else "Принято"
                    Text(text = buttonText, fontSize = 28.sp)
                }
            }
        }

    }
}