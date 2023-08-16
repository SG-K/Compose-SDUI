package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import com.sgk.sduicore.modal.LazyElement
import com.sgk.sduicore.modal.LazyList
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Orientation
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Text as TextElement

@Composable
fun LazyListRenderer(element: LazyList) {

  when (element.orientation) {
    Orientation.HORIZONTAL -> {
      LazyRow(
        modifier = element
          .asModifier()
          .layoutId(element.id)
      ) {
        items(element.children, key = LazyElement::id) {
          CompositeRenderer(it.element)
        }
      }
    }
    Orientation.VERTICAL -> {
      LazyColumn(
        modifier = element
          .asModifier()
          .layoutId(element.id),

        ) {
        items(element.children, key = LazyElement::id) {
          CompositeRenderer(it.element)
        }
      }
    }
  }
}

@Preview(name = "HORIZONTAL Lazy List", "Layout Components")
@Composable
fun LazyListHorizontalRenderer() {
  LazyListRenderer(
    element = LazyList(
      id = "horizontal_list",
      orientation = Orientation.HORIZONTAL,
      style = ElementStyle(
        padding = Padding(
          top = 12,
          bottom = 12,
          left = 12,
          right = 12
        )
      ),
      children = listOf(
        LazyElement(
          id = "1",
          element = TextElement(
            id = "11",
            text = "Lorem",
            textStyle = TextStyle(
              textSize = 24,
              isBold = true,
            ),
            style = ElementStyle(
              padding = Padding(
                top = 12,
                bottom = 12,
                left = 12,
                right = 12
              )
            )
          )
        ),
        LazyElement(
          id = "2",
          element = TextElement(
            text = "ipsum",
            id = "22",
            textStyle = TextStyle(
              textSize = 14,
              isBold = false,
            ),
            style = ElementStyle(
              padding = Padding(
                top = 12,
                bottom = 12,
                left = 12,
                right = 12
              )
            )
          )
        ),
        LazyElement(
          id = "3",
          element = TextElement(
            id = "33",
            text = "dolor sit amet",
            textStyle = TextStyle(
              textSize = 10,
              isBold = false,
            ),
            style = ElementStyle(
              padding = Padding(
                top = 12,
                bottom = 12,
                left = 12,
                right = 12
              )
            )
          )
        ),
      ),
    )
  )

}

@Preview(name = "VERTICAL Lazy List", "Layout Components")
@Composable
fun LazyListVerticalPreview() {
  Box (
    modifier = Modifier.fillMaxSize()
  ){
    LazyListRenderer(
      element = LazyList(
        id = "vertical_list",
        orientation = Orientation.VERTICAL,
        style = ElementStyle(
          padding = Padding(
            top = 12,
            bottom = 12,
            left = 12,
            right = 12
          )
        ),
        children = listOf(
          LazyElement(
            id = "1",
            element = TextElement(
              text = "Lorem",
              textStyle = TextStyle(
                textSize = 24,
                isBold = true,
              ),
              id = "11",
              style = ElementStyle(
                padding = Padding(
                  top = 12,
                  bottom = 12,
                  left = 12,
                  right = 12
                )
              )
            )
          ),
          LazyElement(
            id = "2",
            element = TextElement(
              text = "ipsum",
              textStyle = TextStyle(
                textSize = 14,
                isBold = false,
              ),
              id = "22",
              style = ElementStyle(
                padding = Padding(
                  top = 12,
                  bottom = 12,
                  left = 12,
                  right = 12
                )
              )
            )
          ),
          LazyElement(
            id = "3",
            element = TextElement(
              text = "dolor sit amet",
              textStyle = TextStyle(
                textSize = 10,
                isBold = false,
              ),
              id = "33",
              style = ElementStyle(
                padding = Padding(
                  top = 12,
                  bottom = 12,
                  left = 12,
                  right = 12
                )
              )
            )
          ),
        ),
      )
    )
  }
}
