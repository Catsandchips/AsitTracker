package com.android.slouchingdog.slouchyasit.presentation.screens.intake_journal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.slouchingdog.slouchyasit.R
import com.android.slouchingdog.slouchyasit.domain.entities.IntakeEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntakeJournalScreen() {
    val viewModel: IntakeJournalViewModel = viewModel()
    val intakesList: List<IntakeEntity> by viewModel.intakesList.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Журнал приема") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.menu_24px),
                            contentDescription = "Menu"
                        )
                    }
                })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            intakesList.forEach {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("${it.intakeDate}")
                        Text(it.dosage)
                        Text("${it.dropsNumber} капли")
                        if (it.isTaken) {
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
}