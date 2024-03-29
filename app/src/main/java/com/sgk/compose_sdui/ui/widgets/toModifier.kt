package com.sgk.compose_sdui.ui.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.compose_sdui.helper.toColor
import com.sgk.compose_sdui.ui.widgets.utils.semantics.background
import com.sgk.compose_sdui.ui.widgets.utils.semantics.height
import com.sgk.compose_sdui.ui.widgets.utils.semantics.layoutId
import com.sgk.compose_sdui.ui.widgets.utils.semantics.padding
import com.sgk.compose_sdui.ui.widgets.utils.semantics.width
import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.modal.metadata.Orientation

@SuppressLint("ModifierFactoryExtensionFunction")
fun ElementStyle?.asModifier(): Modifier {

  var modifier: Modifier = Modifier

  if (this == null)
    return modifier


  padding?.let {
    modifier = modifier.padding(
      start = it.left.dp,
      top = it.top.dp,
      end = it.right.dp,
      bottom = it.bottom.dp,
    )
  }

  background?.let {
    if (it.colors.size == 1){
      modifier = modifier.background(it.colors[0].toColor())
    } else if (it.colors.size > 1){
      val brush = if (it.orientation == Orientation.HORIZONTAL){
        Brush.horizontalGradient(it.colors.toColors())
      } else {
        Brush.verticalGradient(it.colors.toColors())
      }
      modifier = modifier.background(brush)
    }
  }

  val _width = width
  modifier = when (_width) {
    is Length.Max -> {
      modifier.fillMaxWidth()
    }
    is Length.Number -> {
      modifier.width(width = _width.value.dp)
    }
    null -> {
      modifier.wrapContentWidth()
    }
  }


  val _height = height
  modifier = when (_height) {
    is Length.Max -> {
      modifier.fillMaxHeight()
    }
    is Length.Number -> {
      modifier.height(_height.value.dp)
    }
    null -> {
      modifier.wrapContentHeight()
    }
  }

  id?.let {
    modifier = modifier
      .layoutId(it)
      .testTag(it)
  }

  val _style = this
  modifier = modifier
    .semantics {
      width = _style.width
      height = _style.height
      background = _style.background
      padding = _style.padding
      layoutId = _style.id
    }

  return modifier
}

@SuppressLint("ModifierFactoryExtensionFunction")
@Composable
fun Element?.asModifier(): Modifier {

  if(this == null)
    return Modifier

  var modifier: Modifier = this.style.asModifier()


//  val onPress = this.interactions?.onPress
//  if (onPress != null) {
//    modifier = modifier.clickable {
//      CompositeInteractor(onPress)
//    }
//  }

  return modifier
}

fun List<String>.toColors() : List<Color>{
  val list = ArrayList<Color>()

  this.map {
    if (it.isNotEmpty()){
      list.add(it.toColor())
    }
  }

  return list
}