package com.sgk.model.adapters

import com.sgk.model.modal.Card
import com.sgk.model.modal.CardStyle
import com.sgk.model.modal.Column
import com.sgk.model.modal.Row
import com.sgk.model.modal.Text
import com.sgk.model.modal.ChildConstraintModel
import com.sgk.model.modal.ConstraintLayout
import com.sgk.model.modal.DirectionConstraints
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Orientation
import com.sgk.model.modal.metadata.Padding
import com.sgk.model.modal.metadata.TextStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dev.aungkyawpaing.loki.adapter.ColumnJsonAdapter
import com.sgk.model.modal.Image
import com.sgk.model.modal.LazyElement
import com.sgk.model.modal.LazyList
import com.sgk.model.modal.Spacer
import com.sgk.model.modal.Element
import com.sgk.model.adapters.constraint_layout.ChildConstraintModelJsonAdapter
import com.sgk.model.adapters.constraint_layout.ConstraintLayoutJsonAdapter
import com.sgk.model.adapters.constraint_layout.DirectionConstraintsJsonAdapter
import com.sgk.model.adapters.metadata.CardStyleJsonAdapter
import com.sgk.model.adapters.metadata.ElementStyleJsonAdapter
import com.sgk.model.adapters.metadata.LengthJsonAdapter
import com.sgk.model.adapters.metadata.OrientationJsonAdapter
import com.sgk.model.adapters.metadata.PaddingJsonAdapter
import com.sgk.model.adapters.metadata.TextStyleJsonAdapter
import com.sgk.model.modal.Button
import com.sgk.model.modal.ButtonStyle
import com.sgk.model.modal.metadata.Length
import dev.aungkyawpaing.loki.adapter.LazyElementJsonAdapter
import dev.aungkyawpaing.loki.adapter.LazyListJsonAdapter
import java.lang.reflect.Type

class SduiJsonAdapterFactory : JsonAdapter.Factory {

    override fun create(type: Type, annotations: MutableSet<out Annotation>, moshi: Moshi): JsonAdapter<*>? {
        return when (type) {
            Element::class.java -> {
                ElementJsonAdapter(
                    moshi.adapter(ConstraintLayout::class.java),
                    moshi.adapter(Column::class.java),
                    moshi.adapter(Text::class.java),
                    moshi.adapter(Row::class.java),
                    moshi.adapter(Image::class.java),
                    moshi.adapter(Card::class.java),
                    moshi.adapter(LazyList::class.java),
                    moshi.adapter(Spacer::class.java),
                    moshi.adapter(Button::class.java),
                )
            }
            ConstraintLayout::class.java -> {
                ConstraintLayoutJsonAdapter(
                    elementJsonAdapter = moshi.adapter(Element::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                    childConstraintModelJsonAdapter = moshi.adapter(ChildConstraintModel::class.java)
                )
            }
            Row::class.java -> {
                RowJsonAdapter(
                    elementJsonAdapter = moshi.adapter(Element::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                )
            }
            Column::class.java -> {
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

            Card::class.java -> {
                CardJsonAdapter(
                    elementJsonAdapter = moshi.adapter(Element::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                    cardStyleJsonAdapter = moshi.adapter(com.sgk.model.modal.CardStyle::class.java),
                )
            }

            CardStyle::class.java -> {
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

            ButtonStyle::class.java -> {
                ButtonStyleJsonAdapter()
            }

            Button::class.java -> {
                ButtonJsonAdapter(
                    buttonStyleJsonAdapter = moshi.adapter(ButtonStyle::class.java),
                    textJsonAdapter = moshi.adapter(Text::class.java),
                    styleJsonAdapter = moshi.adapter(ElementStyle::class.java),
                )
            }

            ElementStyle::class.java -> {
                ElementStyleJsonAdapter(
                    moshi.adapter(Length::class.java), moshi.adapter(Padding::class.java)
                )
            }
            DirectionConstraints::class.java -> {
                DirectionConstraintsJsonAdapter()
            }
            ChildConstraintModel::class.java -> {
                ChildConstraintModelJsonAdapter(
                    moshi.adapter(DirectionConstraints::class.java)
                )
            }

            else -> {
                return null
            }
        }

    }
}
