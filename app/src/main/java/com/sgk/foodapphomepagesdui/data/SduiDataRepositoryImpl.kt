package com.sgk.foodapphomepagesdui.data

import android.content.Context
import android.content.res.AssetManager
import com.sgk.foodapphomepagesdui.domain.SduiDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Assert

class SduiDataRepositoryImpl(
    val assert: AssetManager,
//    context: Context
) : SduiDataRepository {

//    private val assetManager = context.assets

    override fun getProfileScreenJson(): Flow<String> {
        val json = assert.open("home_page.json").bufferedReader().use {
//        val json = assetManager.open("temp.json").bufferedReader().use {
            it.readText()
        }
        return flow {
            emit(json)
        }
    }
}