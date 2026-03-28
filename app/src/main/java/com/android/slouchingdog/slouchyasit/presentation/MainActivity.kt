package com.android.slouchingdog.slouchyasit.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.slouchingdog.slouchyasit.presentation.screens.intake_journal.IntakeJournalScreen
import com.android.slouchingdog.slouchyasit.presentation.theme.SlouchyASITTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlouchyASITTrackerTheme {
                IntakeJournalScreen()
            }
        }
    }
}