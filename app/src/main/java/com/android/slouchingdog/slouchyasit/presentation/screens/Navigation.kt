package com.android.slouchingdog.slouchyasit.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.android.slouchingdog.slouchyasit.presentation.screens.intake_journal.IntakeJournalScreen
import com.android.slouchingdog.slouchyasit.presentation.screens.intake_tracker.IntakeTrackerScreen
import kotlinx.serialization.Serializable

@Serializable
data class IntakeTrackerDestination(val id: String)

@Serializable
object IntakeJournalDestination

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = IntakeJournalDestination) {
        composable<IntakeJournalDestination> {
            IntakeJournalScreen(onIntakeRowClick = {
                navController.navigate(
                    IntakeTrackerDestination(
                        it
                    )
                )
            })
        }
        composable<IntakeTrackerDestination> { backStackEntry ->
            val intakeTrackerDestination: IntakeTrackerDestination = backStackEntry.toRoute()
            IntakeTrackerScreen(
                id = intakeTrackerDestination.id,
                onBackButtonClick = { navController.popBackStack() })
        }
    }
}