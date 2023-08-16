package com.sgk.foodapphomepagesdui.data

import android.content.Context
import com.sgk.foodapphomepagesdui.domain.SduiDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SduiDataRepositoryImpl(
    context: Context
) : SduiDataRepository {

    private val assetManager = context.assets

    override fun getProfileScreenJson(): Flow<String> {
        val json = assetManager.open("home_page.json").bufferedReader().use {
//        val json = assetManager.open("temp.json").bufferedReader().use {
            it.readText()
        }
        return flow {
            emit(json)
        }
    }
}