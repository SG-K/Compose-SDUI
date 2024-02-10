package com.sgk.profile.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sgk.profile.domain.use_case.GetProfilePageData
import com.squareup.moshi.Moshi

@Composable
fun ProfileRoute(
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel = hiltViewModel()
){
    val systemUiController = rememberSystemUiController()

    LaunchedEffect(
        key1 = true
    ){
//        systemUiController.setStatusBarColor(MaterialTheme.colorScheme.background)
    }

    val data = profileViewModel.getProfilePageData.invoke().collectAsState(initial = null).value

    ProfileScreen(data = data, moshi = profileViewModel.moshi)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    data : String?,
    moshi: Moshi
){
    if (data != null) {
        Scaffold(
            modifier = Modifier
        ) {
            Box(modifier = Modifier.padding(it)) {
                com.sgk.ui.widgets.RenderFromJson(
                    json = data,
                    moshi = moshi
                )
            }
        }
    }
}