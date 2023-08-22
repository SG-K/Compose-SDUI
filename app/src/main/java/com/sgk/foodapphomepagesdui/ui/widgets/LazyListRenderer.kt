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
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.addTestSemantics
import com.sgk.sduicore.modal.LazyElement
import com.sgk.sduicore.modal.LazyList
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Orientation
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Text as TextElement

@Composable
fun LazyListRenderer(element: LazyList) {

  val modifier = element
    .asModifier()
    .addTestSemantics(element)

  when (element.orientation) {
    Orientation.HORIZONTAL -> {
      LazyRow(
        modifier = modifier
      ) {
        items(items = element.children, key = LazyElement::lazyElemntId) {
          CompositeRenderer(it.element)
        }
      }
    }
    Orientation.VERTICAL -> {
      LazyColumn(
        modifier = modifier

        ) {
        items( items = element.children, key = LazyElement::lazyElemntId) {
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
      orientation = Orientation.HORIZONTAL,
      style = ElementStyle(
        id = "horizontal_list",
        padding = Padding(
          top = 12,
          bottom = 12,
          left = 12,
          right = 12
        )
      ),
      children = listOf(
        LazyElement(
          lazyElemntId = "1",
          element = TextElement(
            text = "Lorem",
            textStyle = TextStyle(
              textSize = 24,
              isBold = true,
            ),
            style = ElementStyle(
              id = "11",
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
          lazyElemntId = "2",
          element = TextElement(
            text = "ipsum",
            textStyle = TextStyle(
              textSize = 14,
              isBold = false,
            ),
            style = ElementStyle(
              id = "22",
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
          lazyElemntId = "3",
          element = TextElement(

            text = "dolor sit amet",
            textStyle = TextStyle(
              textSize = 10,
              isBold = false,
            ),
            style = ElementStyle(
              id = "33",
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
        orientation = Orientation.VERTICAL,
        style = ElementStyle(
          id = "vertical_list",
          padding = Padding(
            top = 12,
            bottom = 12,
            left = 12,
            right = 12
          )
        ),
        children = listOf(
          LazyElement(
            lazyElemntId = "1",
            element = TextElement(
              text = "Lorem",
              textStyle = TextStyle(
                textSize = 24,
                isBold = true,
              ),
              style = ElementStyle(
                id = "11",
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
            lazyElemntId = "2",
            element = TextElement(
              text = "ipsum",
              textStyle = TextStyle(
                textSize = 14,
                isBold = false,
              ),
              style = ElementStyle(
                id = "22",
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
            lazyElemntId = "3",
            element = TextElement(
              text = "dolor sit amet",
              textStyle = TextStyle(
                textSize = 10,
                isBold = false,
              ),
              style = ElementStyle(
                id = "33",
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
