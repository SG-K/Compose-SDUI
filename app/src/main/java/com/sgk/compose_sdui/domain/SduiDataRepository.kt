package com.sgk.compose_sdui.domain

import kotlinx.coroutines.flow.Flow

interface SduiDataRepository {

    fun getProfileScreenJson() : Flow<String>
    fun getJsonFromFile(jsonFileName : String) : Flow<String>

}