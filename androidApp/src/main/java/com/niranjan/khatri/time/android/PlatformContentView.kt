package com.niranjan.khatri.time.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.niranjan.khatri.time.Platform
import kotlin.math.max
import kotlin.math.min

@Composable
fun PlatformContentView(){
    val items = platformItems()
    LazyColumn( modifier = Modifier.fillMaxSize()){
        items(items){ row ->
            RowView(title = row.first, desc = row.second )
        }
    }
}

@Composable
private fun RowView(
    title: String,
    desc: String
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(8.dp)) {
            Text(text = title, color = Color.Blue, style = MaterialTheme.typography.caption)
            Text(text = desc, style = MaterialTheme.typography.body1)
        }
        Divider()
    }
}

private fun platformItems() : List<Pair<String, String>>{
    val platform = Platform()
    val items = mutableListOf(
        Pair("OS Name:", "${platform.operatingSystemName}"),
        Pair("OS Version:", "${platform.operatingSystemVersion}"),
        Pair("Cpu Type:", "${platform.cpuType}"),
        Pair("Device Model:", "${platform.deviceModel}")
    )

    platform.screenInfo?.let {
        val max = max(it.width, it.height)
        val min = min(it.width, it.height)
        items.add(Pair("Display", "${max}x ${min} @${it.density}"))
    }

    return items
}