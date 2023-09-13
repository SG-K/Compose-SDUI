package com.sgk.sduicore.modal


enum class ElementType(val typeString: String) {
    BUTTON("Button"),
    TEXT("Text"),
    IMAGE("Image"),
    ROW("Row"),
    COLUMN("Column"),
    CONSTRAINT_LAYOUT("ConstraintLayout"),
    CARD("Card"),
    SPACER("Spacer"),
    LAZY_LIST("LazyList");
//    LAZY_GRID("LazyGrid");

    companion object {
        fun fromTypeString(typeString: String?) = values().find { it.typeString == typeString }
    }
}
