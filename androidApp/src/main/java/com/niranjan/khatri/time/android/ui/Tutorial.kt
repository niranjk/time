package com.niranjan.khatri.time.android.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.niranjan.khatri.time.TimeHelper
import com.niranjan.khatri.time.TimeHelperImpl
import com.niranjan.khatri.time.android.R
import com.niranjan.khatri.time.android.theme.primaryColor
import com.niranjan.khatri.time.android.theme.primaryDarkColor
import com.niranjan.khatri.time.android.theme.typography
import kotlinx.coroutines.launch

// JETPACK COMPOSE TUTORIAL


// HOW TO DEFINE A TYPE THAT CAN BE USED THROUGHOUT THE APP?

typealias TypeOne = (List<String>) -> Unit
typealias TypeTwo = () -> Unit
typealias TypeThree = @Composable () -> Unit
typealias TypeFour = @Composable (Int) -> Unit

// HOW TO DEFINE A COMPOSE SCREEN THAT CAN BE
// USED
// THROUGHOUT THE APP ?

sealed class MyScreen(val title: String) {
    object MyFirstScreen : MyScreen("MyFirstTitle")
    object MySecondScreen : MyScreen("MySecondTitle")
}


// What is State in Jetpack Compose and how do you handle
// the state?

// State is any value that can change over time.

// compose functions for handeling states are :
// 1. remember - remember the variable stored between
// redraws of Screens
// mutableStateOf - value holder
// snapshotStateList - MutableList


@Composable
fun composableScreen() {
    val doSomething = remember {
        mutableStateOf(true)
    }
    val savedStrings = remember {
        SnapshotStateList<String>()
    }
    val index = remember {
        mutableStateOf(0)
    }
}

// What is Scaffold in Jetpack Compose?

// Scaffold uses the Material Design Layout
// Structure



// What is TopAppBar ??

// Composable Function for Toolbar


// Floating Action Button



// How to create a BottomNavigation in Jetpack Compose?


// Step 1 : Define your navigation Item
data class MyBottomNavigationItem(
    val route : String,
    val icon: ImageVector,
    val contentDesc : String
)

// Step 2 : Create the list of navigation Items
val myBottomNavigationItemsList = listOf(
    MyBottomNavigationItem(
        route = "Home",
        icon = Icons.Default.Home,
        contentDesc = "Home"
    ),
    MyBottomNavigationItem(
        route = "Account",
        icon = Icons.Default.AccountCircle,
        contentDesc = "Account"
    ),
    MyBottomNavigationItem(
        route = "Setting",
        icon = Icons.Default.Build,
        contentDesc = "Settings"
    )
)
@Preview
@Composable
fun myScaffold() {

    var showDialog = remember {
        mutableStateOf(false)
    }

    val mySelectedIndex = remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            // Add the Toolbar
            TopAppBar(
                title = {
                    Text(text = "My Toolbar Title")
                }
            )     
        },
        floatingActionButton = {
            // Add the Floating Action button
             FloatingActionButton(
                 modifier = Modifier.padding(16.dp),
                 onClick = {
                    showDialog.value = true
                 }) {
                 Icon(imageVector = Icons.Default.Place, contentDescription ="Place" )
             }
        },
        bottomBar = {
            // Bottom Navigation Bar
            // Step 3 - add your BottomNavigation
            BottomNavigation {
                myBottomNavigationItemsList.forEachIndexed {
                        index, myBottomNavigationItem ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = myBottomNavigationItem.icon,
                                contentDescription = myBottomNavigationItem.contentDesc )
                        },
                        selected = mySelectedIndex.value == index,
                        onClick = {
                            mySelectedIndex.value = index
                        }
                    )
                }
            }
        }
    ) {
        if (showDialog.value){
            MyDialog(
                onDismiss = {
                    showDialog.value = false
                }
            )
        }
        Text(
            modifier = Modifier.padding(it),
            text = "My Preview View"
        )
    }
}

// Simple Card Example in Jetpack Compose

@Preview
@Composable
fun MyTutorialCard(
    course: String = "Jetpack Compose",
    time: String = "1:00 PM",
    date: String = "15 August 2023"
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .background(Color.White)
        .padding(8.dp)){
        Card(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Black),
            elevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            // add body
            Box(modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            primaryColor, primaryDarkColor
                        )
                    )
                )
                .padding(8.dp)){
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start
                    ) {
                        Spacer(modifier = Modifier.weight(1.0f))
                        Text(text = "Tutorial", style = typography.h4)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = course, style = typography.h2)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    Spacer(modifier = Modifier.weight(1.0f))
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Spacer(modifier = Modifier.weight(1.0f))
                        Text(text = time, style = typography.h1)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = date, style = typography.h4)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}


// How to create a simple Dialog in JetpackCompose ?

@Preview
@Composable
fun MyDialog(
    onDismiss: () -> Unit = {}
) = Dialog(
    onDismissRequest = onDismiss
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background,
                shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {

        val searchValue = remember { mutableStateOf("") }
        val focusRequester = remember { FocusRequester() }
        Text(text = "My Dialog Screen",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            singleLine = true,
            value = searchValue.value,
            modifier = Modifier
                .focusRequester(focusRequester)
                .fillMaxWidth(),
            onValueChange = {
                searchValue.value = it
                if (searchValue.value.isEmpty()) {
                    return@OutlinedTextField
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    searchValue.value = ""
                }) {
                    Icon(
                        Icons.Filled.Clear,
                        tint = MaterialTheme.colors.secondary,
                        contentDescription = "Cancel",
                    )
                }
            }
        )
        DisposableEffect(Unit) {
            focusRequester.requestFocus()
            onDispose { }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier.align(Alignment.End),
        ) {
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(text = stringResource(id = R.string.cancel))
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(text = stringResource(id = R.string.add))
            }
        }
    }
}
































