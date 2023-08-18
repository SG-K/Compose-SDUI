package com.sgk.foodapphomepagesdui.features.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.sgk.foodapphomepagesdui.ui.widgets.RenderFromJson
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sgk.foodapphomepagesdui.domain.SduiDataRepository
import com.sgk.foodapphomepagesdui.features.profile.domain.use_case.GetProfilePageData
import com.sgk.foodapphomepagesdui.ui.theme.colorBg
import com.squareup.moshi.Moshi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    getProfilePageData: GetProfilePageData,
    moshi: Moshi
){
    val systemUiController = rememberSystemUiController()

    LaunchedEffect(
        key1 = true
    ){
        systemUiController.setStatusBarColor(colorBg)
    }

    val data = getProfilePageData.invoke().collectAsState(initial = null).value

    if (data != null) {
        Scaffold(
            modifier = Modifier
        ) {
            Box(modifier = Modifier.padding(it)) {
                RenderFromJson(
                    json = data,
                    moshi = moshi
                )
            }
        }
    }
}