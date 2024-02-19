package com.sgk.compose_sdui.ui.widgets.image

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.sgk.compose_sdui.R

/**
 * Temporary mapping solution for image rendering as it's
 * a testing sample project
 */

fun String.getImageVector() : ImageVector{
    return when(this){
        "close"-> Icons.Default.Close
        "edit"-> Icons.Outlined.Edit
        "check"-> Icons.Outlined.Check
        "menu"-> Icons.Outlined.Menu
        "mail" -> Icons.Outlined.Email
        "search" -> Icons.Outlined.Search
        "forward_arrow"-> Icons.Outlined.ArrowForward
        "ppv_bg_1"-> Icons.Outlined.ArrowForward
        else -> Icons.Default.ArrowBack
    }
}

@Composable
fun String.getPaintResource() : Painter {
    return when(this){
        "google" -> painterResource(id = R.drawable.ic_google)
        "facebook" -> painterResource(id = R.drawable.ic_facebook)
        "apple" -> painterResource(id = R.drawable.ic_applie)
        "yellow_gradient" -> painterResource(id = R.drawable.ic_bottom_background_icon)
        "aeroplane" -> painterResource(id = R.drawable.ic_aeroplane)
        "world_map" -> painterResource(id = R.drawable.world_map)
        "ppv_bg_1"-> painterResource(id = R.drawable.ppv_bg_1)
        "ppv_bg_2"-> painterResource(id = R.drawable.ppv_bg_2)
        else -> painterResource(id = R.drawable.ic_google)
    }
}