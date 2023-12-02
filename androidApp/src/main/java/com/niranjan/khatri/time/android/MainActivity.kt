package com.niranjan.khatri.time.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.niranjan.khatri.time.android.ui.MainView
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Napier.base(DebugAntilog())
        setContent {

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

            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                // Set up navigation
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "homeScreen") {
                    composable("homeScreen") { HomeScreen(navController) }
                    composable(
                        "deepLinkScreen/{contentId}",
                        arguments = listOf(navArgument("contentId") { type = NavType.StringType })
                    ) { entry ->
                        val contentId = entry.arguments?.getString("contentId")
                        DeepLinkScreen(contentId ?: "")
                    }
                }
            }
            /*
            TimeAppTheme {
                Scaffold {
                    Box(modifier = Modifier.padding(it)){
                        PlatformContentView()
                    }
                }
            }
             */
        }

    }
}
@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Home Screen")

        // Navigate to DeepLinkScreen when the button is clicked
        Button(onClick = { navController.navigate("deepLinkScreen/123") }) {
            Text(text = "Go to Deep Link Screen")
        }
    }
}

@Composable
fun DeepLinkScreen(contentId: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Deep Link Screen\nContent ID: $contentId")
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
