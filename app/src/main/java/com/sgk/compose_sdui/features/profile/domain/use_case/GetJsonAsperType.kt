package com.sgk.compose_sdui.features.profile.domain.use_case

import com.sgk.compose_sdui.domain.SduiDataRepository
import kotlinx.coroutines.flow.Flow

class GetJsonAsperType(
    private val sduiDataRepository: SduiDataRepository
) {

    operator fun invoke(jsonFileName : String) : Flow<String> {
        return sduiDataRepository.getJsonFromFile(jsonFileName)
    }

}