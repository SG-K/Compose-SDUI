package com.sgk.foodapphomepagesdui.data

import androidx.test.platform.app.InstrumentationRegistry
import com.sgk.foodapphomepagesdui.domain.SduiDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeSduiDataRepository : SduiDataRepository {
    override fun getProfileScreenJson(): Flow<String> {
        val assetsManager = InstrumentationRegistry.getInstrumentation().getTargetContext().getAssets()
        val json = assetsManager.open("home_page.json").bufferedReader().use {
            it.readText()
        }
        return flow {
            emit(json)
        }
    }
}