package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.runtime.Composable
import com.sgk.foodapphomepagesdui.di.MoshiInstance
import com.sgk.sduicore.modal.Element
import com.squareup.moshi.Moshi

@Composable
fun RenderFromJson(
  json: String,
  moshi: Moshi
){
//  val element = MoshiInstance.moshi.adapter(Element::class.java).fromJson(json)!!
  val element = moshi.adapter(Element::class.java).fromJson(json)!!
  CompositeRenderer(element)
}