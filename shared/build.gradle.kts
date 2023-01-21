plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
    id("org.jlleitschuh.gradle.ktlint")
    id("org.jetbrains.compose")
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm()
    js(IR) {
        useCommonJs()
        browser()
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Async
                implementation(KotlinX.coroutines.core)

                // Serialization
                implementation(KotlinX.serialization.json)

                // Network
                implementation(Ktor.client.serialization)
                implementation(Ktor.client.logging)

                // Cache
                implementation(Square.sqlDelight.extensions.coroutines)

                // Key-value storage
                implementation(RussHWolf.multiplatformSettings.settings)

                // Logging
                implementation(Touchlab.kermit)

                // DI
                implementation(Koin.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(CashApp.turbine)
                implementation(KotlinX.coroutines.test)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.client.okHttp)
                implementation(Square.sqlDelight.drivers.android)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(Square.sqlDelight.drivers.jdbcSqlite)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Ktor.client.darwin)
                implementation(Square.sqlDelight.drivers.native)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }

        val jvmMain by getting {

        }
        val jvmTest by getting {

        }

        val jsMain by getting {

        }

        val jsTest by getting {

        }
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 28
        targetSdk = 33
    }
}