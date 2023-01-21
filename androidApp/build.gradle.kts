import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.kmmtemplate.android"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    // Original KMM project dependencies
    implementation(Google.Android.material)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.constraintLayout)

    // Lifecycle
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.lifecycle.runtime.ktx)

    // Compose
    implementation(AndroidX.constraintLayout.compose)
    implementation(AndroidX.activity.compose)
    implementation(AndroidX.compose.ui)
    implementation(AndroidX.compose.ui.tooling)
    implementation(AndroidX.compose.material)
    implementation(COIL.compose)

    // Async
    implementation(KotlinX.coroutines.android)

    // DI
    implementation(Koin.android)
    implementation(Koin.androidCompat)

    debugImplementation(AndroidX.compose.ui.tooling)
    debugImplementation(AndroidX.compose.ui.testManifest)

    // Unit Test
    testImplementation(Testing.junit4)
    testImplementation(KotlinX.coroutines.test)
    testImplementation(CashApp.turbine)
    testImplementation(AndroidX.test.ext.junit)

    // UI Test
    androidTestImplementation(AndroidX.test.espresso.core)
    androidTestImplementation(AndroidX.compose.ui.testJunit4)
}