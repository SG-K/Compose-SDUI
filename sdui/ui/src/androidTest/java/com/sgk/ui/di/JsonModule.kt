package com.sgk.ui.di

import android.content.res.AssetManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object JsonModule {

    @Provides
    @Singleton
    @RenderJsonTestDataAnnotation
    fun provideRenderJsonDataString(assetManager: AssetManager): String {
        val json = assetManager.open("render_json_test_data.json").bufferedReader().use {
            it.readText()
        }
        return json
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RenderJsonTestDataAnnotation
