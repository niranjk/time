package com.niranjan.khatri.time.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.niranjan.khatri.time.android.theme.TimeAppTheme
import com.niranjan.khatri.time.android.theme.lightGrey
import com.niranjan.khatri.time.android.theme.primaryDarkColor
import com.niranjan.khatri.time.android.theme.primaryLightColor
import com.niranjan.khatri.time.android.theme.secondaryDarkColor
import com.niranjan.khatri.time.android.theme.secondaryLightColor
import com.niranjan.khatri.time.android.ui.MainView
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Napier.base(DebugAntilog())
        setContent {
            /*
            MainView {
                TopAppBar(
                    title = {
                        when (it){
                            0 -> Text(text = stringResource(id = R.string.world_clocks))
                            else -> Text(text = stringResource(id = R.string.find_meetings))
                        }
                    }
                )
            }
             */
            TimeAppTheme {
                Scaffold {
                    Box(modifier = Modifier.padding(it)){
                        PlatformContentView()
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {

}
