package com.niranjan.khatri.time.android.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.niranjan.khatri.time.android.theme.primaryColor
import com.niranjan.khatri.time.android.theme.primaryDarkColor
import com.niranjan.khatri.time.android.theme.typography

@Composable
fun LocalTimeCard(city: String, time: String, date: String){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .background(Color.White)
        .padding(8.dp)){
        Card(
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(4.dp, Color.DarkGray),
            elevation = 6.dp,
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
                        Text(text = "Location", style = typography.h4)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = city, style = typography.h2)
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