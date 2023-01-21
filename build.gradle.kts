buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.8.0")
        classpath(Android.tools.build.gradlePlugin)
        classpath(Square.sqlDelight.gradlePlugin)
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}