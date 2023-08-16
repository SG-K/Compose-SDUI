package com.sgk.foodapphomepagesdui.ui.widgets

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sgk.sduicore.modal.adapters.ElementJsonAdapter
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.foodapphomepagesdui.helper.toColor
import com.sgk.sduicore.modal.Element

@SuppressLint("ModifierFactoryExtensionFunction")
fun ElementStyle.asModifier(): Modifier {

  var modifier: Modifier = Modifier


  padding?.let {
    modifier = modifier.padding(
      start = it.left.dp,
      top = it.top.dp,
      end = it.right.dp,
      bottom = it.bottom.dp,
    )
  }

  background?.let {
    modifier = modifier.background(it.toColor())
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

  return modifier
}

@SuppressLint("ModifierFactoryExtensionFunction")
@Composable
fun Element.asModifier(): Modifier {

  var modifier: Modifier = this.style?.asModifier() ?: Modifier


//  val onPress = this.interactions?.onPress
//  if (onPress != null) {
//    modifier = modifier.clickable {
//      CompositeInteractor(onPress)
//    }
//  }

  return modifier
}