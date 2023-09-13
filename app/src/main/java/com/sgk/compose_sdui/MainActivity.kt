package com.sgk.compose_sdui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.sgk.compose_sdui.navigation.SduiAppNavHost
import com.sgk.profile.domain.use_case.GetProfilePageData
import com.sgk.profile.presentation.ProfileScreen
import com.sgk.compose_sdui.ui.theme.FoodAppHomePageSDUITheme
import com.squareup.moshi.Moshi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var getProfilePageData : com.sgk.profile.domain.use_case.GetProfilePageData

    @Inject
    lateinit var moshi: Moshi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppHomePageSDUITheme {

                val navController = rememberNavController()

                SduiAppNavHost(
                    navController = navController,
                    onBackClick = {}
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodAppHomePageSDUITheme {
        Greeting("Android")
    }
}