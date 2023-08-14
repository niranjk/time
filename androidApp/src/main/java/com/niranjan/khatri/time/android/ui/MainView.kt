package com.niranjan.khatri.time.android.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.niranjan.khatri.time.android.theme.TimeAppTheme

sealed class Screen(val title: String) {
    object TimeZoneScreen : Screen("Timezones")
    object FindTimeScreen : Screen("Find Time")
}

data class BottomNavigationItem(
    val route: String,
    val icon: ImageVector,
    val iconContentDescription: String
)

val bottomNavigationItems = listOf(
    BottomNavigationItem(
        Screen.TimeZoneScreen.title,
        Icons.Filled.Home,
        "Time Zones"
    ),
    BottomNavigationItem(
        Screen.FindTimeScreen.title,
        Icons.Filled.Place,
        "Find Time"
    )
)

@Composable
fun MainView(actionBarFun: topBarFun = { EmptyComposable() }) {
    val showAddDialog = remember {
        mutableStateOf(false)
    }
    val currentTimezoneStrings = remember {
        SnapshotStateList<String>()
    }
    val selectedIndex = remember {
        mutableStateOf(0)
    }
    TimeAppTheme {
        // add scaffold
        Scaffold(
            topBar = {
                // add toolbar
                actionBarFun(selectedIndex.value)
            },
            floatingActionButton = {
                // add floating action button
                if (selectedIndex.value == 0) {
                    FloatingActionButton(
                        modifier = Modifier.padding(16.dp),
                        onClick = { showAddDialog.value = true }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
                    }
                }
            },
            bottomBar = {
                // add bottom navigation bar
                BottomNavigation {
                    bottomNavigationItems.forEachIndexed { index, bottomNavigationItem ->
                        BottomNavigationItem(
                            selected = selectedIndex.value == index,
                            onClick = { selectedIndex.value = index },
                            icon = { Icon(imageVector = bottomNavigationItem.icon, contentDescription = bottomNavigationItem.iconContentDescription) })
                    }
                }
            }
        ) {
            // add our dialogs
            if (showAddDialog.value){
                AddTimeZoneDialog(
                    onAdd = {newTimezones ->
                        showAddDialog.value = false
                        for (zone in newTimezones){
                            if (!currentTimezoneStrings.contains(zone)){
                                currentTimezoneStrings.add(zone)
                            }
                        }
                    },
                    onDismiss = {
                        showAddDialog.value = false
                    }
                )
            }
            // add our screens
            when(selectedIndex.value){
                0 -> TimeZoneScreen(currentTimezoneStrings = currentTimezoneStrings)
                1 -> FindMeetingScreen(timezoneStrings = currentTimezoneStrings)
            }
        }
    }
}
