plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
//    id("com.google.devtools.ksp")
//    id ("kotlin-android")



}

android {
    namespace = "com.sgk.compose_sdui"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.sgk.compose_sdui"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.sgk.compose_sdui.HiltTestRunner"
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
//    kapt {
//        javacOptions {
//            option("-source", "1.8") // Set the Java version for kapt
//            option("-target", "1.8") // Set the Java version for kapt
//        }
//    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
//        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")

    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")


    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")


    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.30.1")


    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Compose navigation
    implementation("androidx.navigation:navigation-compose:2.6.0")

    // Image Loader
    implementation("io.coil-kt:coil-compose:2.2.2")

    // Moshi
//    implementation ("com.squareup.moshi:moshi:1.14.0")
    implementation("com.squareup.moshi:moshi:1.14.0")
    implementation("com.squareup.moshi:moshi-adapters:1.14.0")
    implementation ("com.squareup.moshi:moshi-kotlin:1.14.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("junit:junit:4.12")
    testImplementation("junit:junit:4.12")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")


    // Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    // Hilt for DI
    implementation ("com.google.dagger:hilt-android:2.44")
    kapt ("com.google.dagger:hilt-compiler:2.44")
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt ("androidx.hilt:hilt-compiler:1.0.0")

    implementation(project(":sduiCore"))


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Local unit tests
    testImplementation ("androidx.test:core:1.4.0")
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
//    testImplementation "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1"
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation ("com.google.truth:truth:1.1.3")
    testImplementation ("com.squareup.okhttp3:mockwebserver:4.9.1")
    testImplementation ("io.mockk:mockk:1.10.5")
//    debugImplementation "androidx.compose.ui:ui-test-manifest:1.1.0-alpha04"
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    // Optional -- Robolectric environment
//    testImplementation "androidx.test:core:$androidXTestVersion"
//    // Optional -- Mockito framework
//    testImplementation "org.mockito:mockito-core:$mockitoVersion"
//    // Optional -- mockito-kotlin
//    testImplementation "org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion"
//    // Optional -- Mockk framework
//    testImplementation "io.mockk:mockk:$mockkVersion"


    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.37")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.37")
    androidTestImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")
    androidTestImplementation ("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation ("com.google.truth:truth:1.1.3")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test:core-ktx:1.4.0")
    androidTestImplementation ("com.squareup.okhttp3:mockwebserver:4.9.1")
//    androidTestImplementation "io.mockk:mockk-android:1.10.5"
    androidTestImplementation ("androidx.test:runner:1.4.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    debugImplementation("androidx.compose.ui:ui-test-junit4")
//    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"

}