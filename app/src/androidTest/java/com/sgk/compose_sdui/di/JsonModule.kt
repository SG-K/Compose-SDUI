package com.sgk.compose_sdui.di

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

    @Provides
    @Singleton
    @HomePageJsonTestDataAnnotation
    fun provideHomePageJsonDataString(assetManager: AssetManager): String {
        val json = assetManager.open("home_page.json").bufferedReader().use {
            it.readText()
        }
        return json
    }

    @Provides
    @Singleton
    @TextRenderJsonTestDataAnnotation
    fun provideTextRenderJsonDataString(assetManager: AssetManager): String {
        val json = assetManager.open("text_render_test_data.json").bufferedReader().use {
            it.readText()
        }
        return json
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RenderJsonTestDataAnnotation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HomePageJsonTestDataAnnotation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TextRenderJsonTestDataAnnotation