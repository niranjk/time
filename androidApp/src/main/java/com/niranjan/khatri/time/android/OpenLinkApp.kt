package com.niranjan.khatri.time.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OpenLinkApp( openEntry: (String)-> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Home Screen")
        // Navigate to DeepLinkScreen when the button is clicked
        Button(onClick = {
            openEntry("http://www.google.com") // enter the valid url
        }) {
            Text(text = "OpenLink")
        }
    }
}