package com.sgk.sduicore.modal.adapters

import com.sgk.sduicore.modal.Card
import com.sgk.sduicore.modal.CardStyle
import com.sgk.sduicore.modal.Column
import com.sgk.sduicore.modal.adapters.ElementJsonAdapter
import com.sgk.sduicore.modal.Row
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.modal.ChildConstraintModel
import com.sgk.sduicore.modal.ConstraintLayout
import com.sgk.sduicore.modal.DirectionConstraints
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Orientation
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dev.aungkyawpaing.loki.adapter.ColumnJsonAdapter
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.LazyElement
import com.sgk.sduicore.modal.LazyList
import com.sgk.sduicore.modal.Spacer
import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.modal.adapters.constraint_layout.ChildConstraintModelJsonAdapter
import com.sgk.sduicore.modal.adapters.constraint_layout.ConstraintLayoutJsonAdapter
import com.sgk.sduicore.modal.adapters.constraint_layout.DirectionConstraintsJsonAdapter
import com.sgk.sduicore.modal.adapters.metadata.CardStyleJsonAdapter
import com.sgk.sduicore.modal.adapters.metadata.ElementStyleJsonAdapter
import com.sgk.sduicore.modal.adapters.metadata.LengthJsonAdapter
import com.sgk.sduicore.modal.adapters.metadata.OrientationJsonAdapter
import com.sgk.sduicore.modal.adapters.metadata.PaddingJsonAdapter
import com.sgk.sduicore.modal.adapters.metadata.TextStyleJsonAdapter
import com.sgk.sduicore.modal.metadata.Length
import dev.aungkyawpaing.loki.adapter.LazyElementJsonAdapter
import dev.aungkyawpaing.loki.adapter.LazyListJsonAdapter
import java.lang.reflect.Type

class SduiJsonAdapterFactory : JsonAdapter.Factory {

    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        return when (type) {
            Element::class.java -> {
                ElementJsonAdapter(
                    moshi.adapter(com.sgk.sduicore.modal.ConstraintLayout::class.java),
                    moshi.adapter(com.sgk.sduicore.modal.Column::class.java),
                    moshi.adapter(Text::class.java),
                    moshi.adapter(Row::class.java),
                    moshi.adapter(Image::class.java),
                    moshi.adapter(com.sgk.sduicore.modal.Card::class.java),
                    moshi.adapter(LazyList::class.java),
                    moshi.adapter(Spacer::class.java),
                )
            }
            com.sgk.sduicore.modal.ConstraintLayout::class.java -> {
                ConstraintLayoutJsonAdapter(
                    elementJsonAdapter = moshi.adapter(Element::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                    childConstraintModelJsonAdapter = moshi.adapter(com.sgk.sduicore.modal.ChildConstraintModel::class.java)
                )
            }
            Row::class.java -> {
                RowJsonAdapter(
                    elementJsonAdapter = moshi.adapter(Element::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                )
            }
            com.sgk.sduicore.modal.Column::class.java -> {
                ColumnJsonAdapter(
                    elementJsonAdapter = moshi.adapter(Element::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java)
                )
            }
            TextStyle::class.java -> {
                TextStyleJsonAdapter()
            }

            Text::class.java -> {
                TextJsonAdapter(
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                    textStyleJsonAdapter =  moshi.adapter(TextStyle::class.java)
                )
            }

            Image::class.java -> {
                ImageJsonAdapter(
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java)
                )
            }

            Spacer::class.java -> {
                SpacerJsonAdapter(
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java)
                )
            }

            com.sgk.sduicore.modal.Card::class.java -> {
                CardJsonAdapter(
                    elementJsonAdapter = moshi.adapter(Element::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                    cardStyleJsonAdapter = moshi.adapter(com.sgk.sduicore.modal.CardStyle::class.java),
                )
            }

            com.sgk.sduicore.modal.CardStyle::class.java -> {
                CardStyleJsonAdapter()
            }

            LazyElement::class.java -> {
                LazyElementJsonAdapter(
                    elementJsonAdapter = moshi.adapter(Element::class.java),
                )
            }

            LazyList::class.java -> {
                LazyListJsonAdapter(
                    lazyElementJsonAdapter = moshi.adapter(LazyElement::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                    orientationJsonAdapter = moshi.adapter(Orientation::class.java),
                )
            }

            Orientation::class.java -> {
                OrientationJsonAdapter()
            }
            Padding::class.java -> {
                PaddingJsonAdapter()
            }
            Length::class.java -> {
                LengthJsonAdapter()
            }
            ElementStyle::class.java -> {
                ElementStyleJsonAdapter(
                    moshi.adapter(Length::class.java), moshi.adapter(Padding::class.java)
                )
            }
            com.sgk.sduicore.modal.DirectionConstraints::class.java -> {
                DirectionConstraintsJsonAdapter()
            }
            com.sgk.sduicore.modal.ChildConstraintModel::class.java -> {
                ChildConstraintModelJsonAdapter(
                    moshi.adapter(com.sgk.sduicore.modal.DirectionConstraints::class.java)
                )
            }

            else -> {
                return null
            }
        }

    }
}
