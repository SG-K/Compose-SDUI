package com.sgk.profile.domain

import kotlinx.coroutines.flow.Flow

interface SduiDataRepository {

    fun getProfileScreenJson() : Flow<String>

}