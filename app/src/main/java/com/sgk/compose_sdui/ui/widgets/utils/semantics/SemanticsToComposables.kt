package com.sgk.compose_sdui.ui.widgets.utils.semantics

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import com.sgk.compose_sdui.ui.widgets.image.getImageVector
import com.sgk.model.modal.Card
import com.sgk.model.modal.Image
import com.sgk.model.modal.LazyList
import com.sgk.model.modal.Text

fun Modifier.addTestSemantics(element : Text) : Modifier{
    return this.semantics {
        textColor = element.textStyle.textColor
        textSize = element.textStyle.textSize
        isTextBold = element.textStyle.isBold
    }
}

fun Modifier.addTestSemantics(element : Image) : Modifier{
    return this.semantics {
        imageUrl = element.url
        imageType = element.imageType
        tint = element.tint
        vectorUrl = element.url.getImageVector()
    }
}

fun Modifier.addTestSemantics(element : Card) : Modifier{
    return this.semantics {
        cardElevation = element.cardStyle?.elevation
        cardRadius = element.cardStyle?.radius
        cardContentColor = element.cardStyle?.contentColor
    }
}

fun Modifier.addTestSemantics(element : LazyList) : Modifier{
    return this.semantics {
        orientation = element.orientation
    }
}