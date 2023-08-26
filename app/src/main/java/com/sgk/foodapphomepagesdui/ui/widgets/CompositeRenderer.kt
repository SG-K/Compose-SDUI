package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.runtime.Composable
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.LazyList
import com.sgk.sduicore.modal.Row
import com.sgk.sduicore.modal.Spacer
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.adapters.constraint_layout.print
import com.sgk.foodapphomepagesdui.ui.widgets.constraint_layout.ConstraintLayoutRenderer
import com.sgk.sduicore.modal.Button
import com.sgk.sduicore.modal.Element

/**
 * TODO: Pending UI tests for this widget
 */
@Composable
fun CompositeRenderer(element: Element) {
  when (element) {
    is Text -> {
      TextRenderer(textElement = element)
    }
    is Image -> {
      ImageRenderer(imgElement = element)
    }
    is LazyList -> {
      LazyListRenderer(element = element)
    }
//    is LazyGrid -> {
//      LazyGridRenderer(element = element)
//    }
    is com.sgk.sduicore.modal.Column -> {
      ColumnRenderer(element = element)
    }
    is Row -> {
      RowRenderer(element = element)
    }
    is Spacer -> {
      SpacerRenderer(element = element)
    }
    is com.sgk.sduicore.modal.ConstraintLayout -> {
      "entered into contraintlauout".print()
      ConstraintLayoutRenderer( element = element)
    }

    is com.sgk.sduicore.modal.Card -> {
      CardRenderer(element = element)
    }
    is Button -> {
      ButtonRenderer(element = element)
    }

  }
}