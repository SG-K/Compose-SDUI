package com.sgk.sduicore.modal.adapters

import com.squareup.moshi.JsonReader

object AdapterConstants {
    const val KEY_ID = "id"
    const val KEY_ELEMENT = "element"
    const val KEY_TYPE = "type"
    const val KEY_ORIENTATION = "orientation"
    const val KEY_CHILDREN = "children"
    const val KEY_STYLE = "style"
    const val KEY_URL = "url"
    const val KEY_ALT_TEXT = "altText"
    const val KEY_IMAGE_TYPE = "imageType"
    const val KEY_TINT = "tint"
    const val KEY_CONSTRAINT_DIRECTION = "contraintDirection"
    const val KEY_CONSTRAINT_COMPOSABLE_ID = "constraintComposableId"
    const val KEY_MARGIN = "margin"
    const val KEY_WIDTH_CONSTRAINT = "width_constraint"
    const val KEY_HEIGHT_CONSTRAINT = "height_constraint"
    const val KEY_REF_ID = "refId"
    const val KEY_TOP = "top"
    const val KEY_BOTTOM = "bottom"
    const val KEY_START = "start"
    const val KEY_END = "end"
    const val KEY_SIZE = "size"
    const val KEY_RADIUS = "radius"
    const val KEY_CONTENT_COLOR = "contentColor"
    const val KEY_ELEVATION = "elevation"




    val KEY_OPTIONS_LAZY_ELEMENT = JsonReader.Options.of(
        KEY_ID,
        KEY_ELEMENT
    )
    val KEY_OPTIONS_LAZY_LIST = JsonReader.Options.of(
        KEY_ORIENTATION,
        KEY_CHILDREN,
        KEY_STYLE,
        KEY_ID
    )
    val KEY_OPTIONS_IMAGE = JsonReader.Options.of(
        KEY_URL,
        KEY_ALT_TEXT,
        KEY_IMAGE_TYPE,
        KEY_STYLE,
        KEY_ID,
        KEY_TINT
    )
    val KEY_OPTIONS_DIRECTION_CONSTRAINT = JsonReader.Options.of(
        KEY_CONSTRAINT_DIRECTION,
        KEY_CONSTRAINT_COMPOSABLE_ID,
        KEY_MARGIN
    )
    val KEY_OPTIONS_CHILD_CONTRAINT_SET = JsonReader.Options.of(
        KEY_REF_ID,
        KEY_TOP,
        KEY_BOTTOM,
        KEY_START,
        KEY_END,
        KEY_WIDTH_CONSTRAINT,
        KEY_HEIGHT_CONSTRAINT
    )

    val KEY_OPTIONS_SPACER = JsonReader.Options.of(
        KEY_SIZE,
        KEY_STYLE,
        KEY_ID
    )

    val KEY_OPTIONS_CARD_STYLE = JsonReader.Options.of(
        KEY_RADIUS,
        KEY_CONTENT_COLOR,
        KEY_ELEVATION
    )


}