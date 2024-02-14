package com.sgk.compose_sdui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sgk.compose_sdui.features.profile.domain.use_case.GetJsonAsperType
import com.sgk.compose_sdui.features.profile.domain.use_case.GetProfilePageData
import com.sgk.compose_sdui.features.profile.presentation.NewLandingPageHeader
import com.sgk.compose_sdui.features.profile.presentation.ProfileScreen
import com.sgk.compose_sdui.ui.theme.FoodAppHomePageSDUITheme
import com.squareup.moshi.Moshi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var getProfilePageData : GetProfilePageData

    @Inject
    lateinit var getJsonAsperType: GetJsonAsperType

    @Inject
    lateinit var moshi: Moshi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            FoodAppHomePageSDUITheme {
                // A surface container using the 'background' color from the theme

                NavHost(
                    navController = navController,
                    startDestination = "buttons"
                ) {

                    composable("buttons") {
                        ThreeButtons(
                            click = {
                                navController.navigate(it)
                            }
                        )
                    }

                    composable("1") {
                        NewLandingPageHeader(
                            fileName = "demo.json",
                            getJsonAsperType = getJsonAsperType,
                            moshi = moshi
                        )
                    }

                    composable("2") {
                        NewLandingPageHeader(
                            fileName = "dazn_top_bar.json",
                            getJsonAsperType = getJsonAsperType,
                            moshi = moshi
                        )
                    }

                    composable("3") {
                        NewLandingPageHeader(
                            fileName = "portability.json",
                            getJsonAsperType = getJsonAsperType,
                            moshi = moshi
                        )
                    }

                    composable("4") {
                        NewLandingPageHeader(
                            fileName = "dazn_boxing_ppv.json",
                            getJsonAsperType = getJsonAsperType,
                            moshi = moshi
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun ThreeButtons(
    click : (String) -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){

        Button(onClick = {
            click("1")
        }) {
            Text(text = "Landing page Header")
        }

        Spacer(modifier = Modifier.height( 16.dp))

        Button(onClick = {
            click("2")
        }) {
            Text(text = "Dazn Top Bar")
        }

        Spacer(modifier = Modifier.height( 16.dp))

        Button(onClick = {
            click("3")
        }) {
            Text(text = "Dazn Portability")
        }

        Spacer(modifier = Modifier.height( 16.dp))

        Button(onClick = {
            click("4")
        }) {
            Text(text = "Last PPV Landing Page")
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