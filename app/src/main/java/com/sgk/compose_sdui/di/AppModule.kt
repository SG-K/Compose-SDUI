package com.sgk.compose_sdui.di

import android.app.Application
import android.content.res.AssetManager
import com.sgk.compose_sdui.data.SduiDataRepositoryImpl
import com.sgk.compose_sdui.domain.SduiDataRepository
import com.sgk.compose_sdui.features.profile.domain.use_case.GetJsonAsperType
import com.sgk.compose_sdui.features.profile.domain.use_case.GetProfilePageData
import com.sgk.sduicore.adapters.SduiJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEasyToDoRepository(assetManager: AssetManager): SduiDataRepository {
        return SduiDataRepositoryImpl(assetManager)
    }

    @Provides
    @Singleton
    fun provideAssetManager(app: Application): AssetManager {
        return app.assets
    }

    @Provides
    @Singleton
    fun provideGetUseCases(repository: SduiDataRepository): GetProfilePageData {
        return GetProfilePageData(
            sduiDataRepository = repository
        )
    }

    @Provides
    @Singleton
    fun provideGetJsonAsperTypeUsecase(repository: SduiDataRepository): GetJsonAsperType {
        return GetJsonAsperType(
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