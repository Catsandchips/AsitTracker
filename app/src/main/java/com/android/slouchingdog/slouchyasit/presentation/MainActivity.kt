package com.android.slouchingdog.slouchyasit.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.android.slouchingdog.slouchyasit.data.worker.ScheduleManager
import com.android.slouchingdog.slouchyasit.presentation.screens.Navigation
import com.android.slouchingdog.slouchyasit.presentation.theme.SlouchyASITTrackerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var scheduleManager: ScheduleManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scheduleManager.scheduleDailyIntakeCreation()
        enableEdgeToEdge()
        setContent {
            SlouchyASITTrackerTheme {
                Navigation()
            }
        }
    }
}