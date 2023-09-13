package com.sgk.profile.data

import android.content.res.AssetManager
import com.sgk.profile.domain.SduiDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SduiDataRepositoryImpl(
    val assert: AssetManager,
//    context: Context
) : com.sgk.profile.domain.SduiDataRepository {

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