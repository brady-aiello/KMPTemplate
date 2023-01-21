pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }

    plugins {
        val kotlinVersion = "1.7.20"
        val agpVersion = "7.4.0-beta02"
        val composeVersion = "1.2.2"
        val sqlDelightVersion = "1.5.5"
        val ktlintVersion = "11.0.0"

        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("com.android.application") version agpVersion
        id("com.android.library") version agpVersion
        id("com.squareup.sqldelight") version sqlDelightVersion
        id("org.jetbrains.compose") version composeVersion
        id("org.jlleitschuh.gradle.ktlint") version ktlintVersion
    }
}

plugins {
    // See https://jmfayard.github.io/refreshVersions
    id("de.fayard.refreshVersions") version "0.51.0"
}

rootProject.name = "KMPTemplate"
include(":androidApp")
include(":shared")