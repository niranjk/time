package com.niranjan.khatri.time.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niranjan.khatri.time.TimeZoneHelper
import com.niranjan.khatri.time.TimeZoneHelperImpl

@Composable
fun FindMeetingScreen(
    timezoneStrings : List<String>
){
    val listState = rememberLazyListState()
    val startTime = remember {
        mutableStateOf(8)
    }
    val endTime = remember {
        mutableStateOf(17)
    }
    val selectedTimeZones = remember {
        val selected = SnapshotStateMap<Int, Boolean>()
        for (i in 0..timezoneStrings.size -1) selected[i] = true
        selected
    }
    val timeZoneHelper: TimeZoneHelper = TimeZoneHelperImpl()
    val showMeetingDialog = remember {
        mutableStateOf(false)
    }
    val meetingHours = remember {
        SnapshotStateList<Int>()
    }

    if (showMeetingDialog.value){
        MeetingDialog(hours = meetingHours,
            onDismiss = {
                showMeetingDialog.value = false
            })
    }
    // add content

    Column {
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            text = "Time Range",
            style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.size(16.dp))
        Row {
            Spacer(modifier = Modifier.size(16.dp))
            NumberTimeCard(label = "Start", hour = startTime)
            Spacer(modifier = Modifier.size(32.dp))
            NumberTimeCard(label = "End", hour = endTime)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally),
                text = "Time Zones",
                style = MaterialTheme.typography.h6)
        }
        Spacer(modifier = Modifier.size(16.dp))

        // add lazycolumn
        LazyColumn(
            modifier = Modifier
                .weight(0.6F)
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            state = listState
        ){
            itemsIndexed(timezoneStrings){i, timezone ->
                Surface(
                    Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                    ) {
                        Checkbox(checked = isSelected(selectedTimeZones, i), onCheckedChange = {
                            selectedTimeZones[i] = it
                        })
                        Text(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            text = timezone)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Row(
            Modifier
                .fillMaxWidth()
                .weight(0.2F)
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 4.dp, end = 4.dp)
        ) {
            OutlinedButton(onClick = {
                meetingHours.clear()
                meetingHours.addAll(
                    timeZoneHelper.search(startTime.value, endTime.value,
                        getSelectedTimeZones(timezoneStrings, selectedTimeZones)
                    )
                )
                showMeetingDialog.value = true
            }) {
                Text(text = "Search")
            }
        }

        Spacer(modifier = Modifier.size(16.dp))
    }

}

// add getselectedtimezones
fun getSelectedTimeZones(
    timezoneStrings : List<String>,
    selectedStates: Map<Int, Boolean>
): List<String>{
    val selectedTimezones = mutableListOf<String>()
    selectedStates.keys.map {
        val timezone = timezoneStrings[it]
        if (isSelected(selectedStates, it) && !selectedTimezones.contains(timezone)){
            selectedTimezones.add(timezone)
        }
    }
    return selectedTimezones
}

