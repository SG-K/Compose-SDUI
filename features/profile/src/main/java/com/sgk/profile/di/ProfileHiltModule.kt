package com.sgk.profile.di

import android.app.Application
import android.content.res.AssetManager
import com.sgk.model.adapters.SduiJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileHiltModule {

    @Provides
    @Singleton
    fun provideEasyToDoRepository(assetManager: AssetManager): com.sgk.profile.domain.SduiDataRepository {
        return com.sgk.profile.data.SduiDataRepositoryImpl(assetManager)
    }

    @Provides
    @Singleton
    fun provideAssetManager(app: Application): AssetManager {
        return app.assets
    }

    @Provides
    @Singleton
    fun provideGetUseCases(repository: com.sgk.profile.domain.SduiDataRepository): com.sgk.profile.domain.use_case.GetProfilePageData {
        return com.sgk.profile.domain.use_case.GetProfilePageData(
            sduiDataRepository = repository
        )
    }

    @Provides
    @Singleton
    fun provideMoshiInstance(): Moshi {
        return Moshi.Builder()
            .add(SduiJsonAdapterFactory())
//         .addLast(KotlinJsonAdapterFactory())
//         .add(EnumJsonAdapter(ElementType::class.java))
//         .add(EnumJsonAdapter(Orientation::class.java))
//         .add(EnumJsonAdapter(ContraintDirections::class.java))
//         .add(
//             PolymorphicJsonAdapterFactory.of(Length::class.java, "Length")
//                 .withSubtype(Length.Max::class.java, "max")
//                 .withSubtype(Length.Number::class.java, "number")
////                 .withDefaultValue(Length.Max)
//         )
//         .add(LengthJsonAdapter())
//         .add(KotlinJsonAdapterFactory())
            .build()
    }


}