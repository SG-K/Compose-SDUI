package com.sgk.compose_sdui.data

import android.content.res.AssetManager
import com.sgk.compose_sdui.domain.SduiDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SduiDataRepositoryImpl(
    val assert: AssetManager,
//    context: Context
) : SduiDataRepository {

//    private val assetManager = context.assets

    override fun getProfileScreenJson(): Flow<String> {
//        val json = assert.open("home_page.json").bufferedReader().use {
//        val json = assert.open("dazn_boxing_ppv.json").bufferedReader().use {
        val json = assert.open("portability.json").bufferedReader().use {
//        val json = assert.open("demo.json").bufferedReader().use {
            it.readText()
        }
        return flow {
            emit(json)
        }
    }

    override fun getJsonFromFile(jsonFileName: String): Flow<String> {
        val json = assert.open(jsonFileName).bufferedReader().use {
            it.readText()
        }
        return flow {
            emit(json)
        }
    }
}