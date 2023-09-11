package com.sgk.compose_sdui.features.profile.domain.use_case

import com.sgk.compose_sdui.domain.SduiDataRepository
import kotlinx.coroutines.flow.Flow

class GetProfilePageData(
    private val sduiDataRepository: SduiDataRepository
) {

    operator fun invoke() : Flow<String> {
        return sduiDataRepository.getProfileScreenJson()
    }

}