package com.android.slouchingdog.slouchyasit.presentation.screens.modal_navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModalNavigation() {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text(text = "Slouchy ASIT", style = MaterialTheme.typography.titleLarge)
                HorizontalDivider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                )
                NavigationDrawerItem(
                    label = { Text("Сегодняшний прием") },
                    selected = true,
                    onClick = {}
                )
                HorizontalDivider(
                    thickness = 2.dp,
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                )
                NavigationDrawerItem(
                    label = { Text("Дневник приема") },
                    selected = false,
                    onClick = {}
                )
            }
        }
    ) { }
}

@Preview
@Composable
fun ModalNavigationPreview() {
    ModalNavigation()
}