package com.sgk.profile.domain.use_case

import com.sgk.profile.domain.SduiDataRepository
import kotlinx.coroutines.flow.Flow

class GetProfilePageData(
    private val sduiDataRepository: SduiDataRepository
) {

    operator fun invoke() : Flow<String> {
        return sduiDataRepository.getProfileScreenJson()
    }

}