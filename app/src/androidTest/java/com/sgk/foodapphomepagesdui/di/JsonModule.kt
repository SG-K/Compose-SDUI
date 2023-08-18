package com.sgk.foodapphomepagesdui.di

import android.app.Application
import android.content.res.AssetManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RenderJsonTestDataAnnotation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HomePageJsonTestDataAnnotation

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

}