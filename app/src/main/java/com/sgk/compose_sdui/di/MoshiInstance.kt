package com.sgk.compose_sdui.di

import com.sgk.model.adapters.SduiJsonAdapterFactory
import com.squareup.moshi.Moshi

object MoshiInstance {

  private var _moshi : Moshi? = null

  val moshi : Moshi get() {
    if (_moshi == null ) {
     _moshi = Moshi.Builder()
        .add(SduiJsonAdapterFactory())
//         .addLast(KotlinJsonAdapterFactory())
//         .add(EnumJsonAdapter(ElementType::class.java))
//         .add(EnumJsonAdapter(Orientation::class.java))
//         .add(EnumJsonAdapter(ContraintDirections::class.java))
//         .add(
//             PolymorphicJsonAdapterFactory.of(Length::class.java, "Length")
//                 .withSubtype(Length.Max::class.java, "max")
//                 .withSubtype(Length.Number::class.java, "number")
////                 .withDefaultValue(Length.Max)
//         )
//         .add(LengthJsonAdapter())
//         .add(KotlinJsonAdapterFactory())
         .build()
    }
    return _moshi!!
  }

}