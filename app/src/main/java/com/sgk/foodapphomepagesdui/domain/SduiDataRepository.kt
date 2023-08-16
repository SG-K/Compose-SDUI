package com.sgk.foodapphomepagesdui.domain

import kotlinx.coroutines.flow.Flow

interface SduiDataRepository {

    fun getProfileScreenJson() : Flow<String>

}