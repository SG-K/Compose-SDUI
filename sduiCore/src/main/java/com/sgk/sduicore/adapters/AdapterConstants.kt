package com.sgk.sduicore.adapters

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
        com.sgk.sduicore.adapters.AdapterConstants.KEY_ID,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_ELEMENT
    )
    val KEY_OPTIONS_LAZY_LIST = JsonReader.Options.of(
        com.sgk.sduicore.adapters.AdapterConstants.KEY_ORIENTATION,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_CHILDREN,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_STYLE,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_ID
    )
    val KEY_OPTIONS_IMAGE = JsonReader.Options.of(
        com.sgk.sduicore.adapters.AdapterConstants.KEY_URL,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_ALT_TEXT,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_IMAGE_TYPE,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_STYLE,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_ID,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_TINT
    )
    val KEY_OPTIONS_DIRECTION_CONSTRAINT = JsonReader.Options.of(
        com.sgk.sduicore.adapters.AdapterConstants.KEY_CONSTRAINT_DIRECTION,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_CONSTRAINT_COMPOSABLE_ID,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_MARGIN
    )
    val KEY_OPTIONS_CHILD_CONTRAINT_SET = JsonReader.Options.of(
        com.sgk.sduicore.adapters.AdapterConstants.KEY_REF_ID,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_TOP,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_BOTTOM,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_START,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_END,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_WIDTH_CONSTRAINT,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_HEIGHT_CONSTRAINT
    )

    val KEY_OPTIONS_SPACER = JsonReader.Options.of(
        com.sgk.sduicore.adapters.AdapterConstants.KEY_SIZE,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_STYLE,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_ID
    )

    val KEY_OPTIONS_CARD_STYLE = JsonReader.Options.of(
        com.sgk.sduicore.adapters.AdapterConstants.KEY_RADIUS,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_CONTENT_COLOR,
        com.sgk.sduicore.adapters.AdapterConstants.KEY_ELEVATION
    )


}