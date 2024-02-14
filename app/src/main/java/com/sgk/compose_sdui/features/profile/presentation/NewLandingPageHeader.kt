package com.sgk.compose_sdui.features.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sgk.compose_sdui.features.profile.domain.use_case.GetJsonAsperType
import com.sgk.compose_sdui.ui.theme.colorBg
import com.sgk.compose_sdui.ui.widgets.RenderFromJson
import com.squareup.moshi.Moshi

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NewLandingPageHeader(
    fileName : String,
    getJsonAsperType: GetJsonAsperType,
    moshi: Moshi
){

    val systemUiController = rememberSystemUiController()

    LaunchedEffect(
        key1 = true
    ){
        systemUiController.setStatusBarColor(colorBg)
    }

    val data = getJsonAsperType.invoke(fileName).collectAsState(initial = null).value

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