package com.sgk.sduicore.modal.metadata



enum class LengthType{
    NUMBER,
    Max
}

sealed class Length(
//    @Json(name="LengthType") val lengthtype: LengthType
) {
    //    data class Number(val value: Int) : Length(LengthType.NUMBER)
//    @JsonClass(generateAdapter = true)
    data class Number(val value: Int) : Length()
//    @JsonClass(generateAdapter = true)
    object Max : Length()
//    object Unknown : Length()

}
