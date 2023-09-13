package com.sgk.ui.widgets

import androidx.compose.runtime.Composable
import com.sgk.model.modal.Image
import com.sgk.model.modal.LazyList
import com.sgk.model.modal.Row
import com.sgk.model.modal.Spacer
import com.sgk.model.modal.Text
import com.sgk.ui.widgets.constraint_layout.ConstraintLayoutRenderer
import com.sgk.model.modal.Button
import com.sgk.model.modal.Element

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
    is com.sgk.model.modal.Column -> {
      ColumnRenderer(element = element)
    }
    is Row -> {
      RowRenderer(element = element)
    }
    is Spacer -> {
      SpacerRenderer(element = element)
    }
    is com.sgk.model.modal.ConstraintLayout -> {
      ConstraintLayoutRenderer( element = element)
    }

    is com.sgk.model.modal.Card -> {
      CardRenderer(element = element)
    }
    is Button -> {
      ButtonRenderer(element = element)
    }

  }
}