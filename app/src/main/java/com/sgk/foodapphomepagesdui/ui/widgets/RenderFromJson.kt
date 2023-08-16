package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.runtime.Composable
import com.sgk.foodapphomepagesdui.di.MoshiInstance
import com.sgk.sduicore.modal.Element

@Composable
fun RenderFromJson(json: String){
  val element = MoshiInstance.moshi.adapter(Element::class.java).fromJson(json)!!
  CompositeRenderer(element)
}