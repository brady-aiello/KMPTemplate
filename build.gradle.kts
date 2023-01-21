buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
//        classpath("org.jetbrains.kotlin:kotlin-serialization:1.7.20")
//        classpath(Android.tools.build.gradlePlugin)
//        classpath(Square.sqlDelight.gradlePlugin)
//    }
}

plugins {
    //id("org.jlleitschuh.gradle.ktlint") apply false
    id("org.jetbrains.compose") apply false
    kotlin("jvm") apply false
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
}

allprojects {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}