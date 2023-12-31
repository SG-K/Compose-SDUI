// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.0" apply false
//    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
//    id("com.google.devtools.ksp") version "1.6.10-1.0.9" apply false

}

buildscript {
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44")
    }
}


allprojects {
    // ...
//    tasks.withType<JavaCompile> {
//        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
//        targetCompatibility = JavaVersion.VERSION_1_8.toString()
//    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
