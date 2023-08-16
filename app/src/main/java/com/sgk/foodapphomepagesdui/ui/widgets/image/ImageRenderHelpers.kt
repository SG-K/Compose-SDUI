package com.sgk.foodapphomepagesdui.ui.widgets.image

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.sgk.foodapphomepagesdui.R

fun String.getImageVector() : ImageVector{
    return when(this){
        "close"-> Icons.Default.Close
        "edit"-> Icons.Outlined.Edit
        "check"-> Icons.Outlined.Check
        else -> Icons.Default.ArrowBack
    }
}

@Composable
fun String.getPaintResource() : Painter {
    return when(this){
        "google" -> painterResource(id = R.drawable.ic_google)
        "facebook" -> painterResource(id = R.drawable.ic_facebook)
        "apple" -> painterResource(id = R.drawable.ic_applie)
        else -> painterResource(id = R.drawable.ic_google)
    }
}