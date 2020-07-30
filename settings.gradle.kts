@file:Suppress("UnstableApiUsage", "LocalVariableName")

rootProject.name = "dokka"

include("core")
include("plugins:base:search-component")
include("testApi")
include("test-tools")
include("runners:gradle-plugin")
include("runners:cli")
include("runners:maven-plugin")
include("kotlin-analysis")
include("kotlin-analysis:dependencies")
include("plugins:base")
include("plugins:base:frontend")
include("plugins:base:test-utils")
include("plugins:mathjax")
include("plugins:gfm")
include("plugins:jekyll")
include("plugins:kotlin-as-java")
include("plugins:javadoc")
include("integration-tests")
include("integration-tests:gradle")
include("integration-tests:cli")
include("integration-tests:maven")


pluginManagement {
    val kotlin_version: String by settings
    val dokka_jcenter_repository: String by settings
    val dokka_kotlin_eap_repository: String by settings
    val dokka_kotlin_dev_repository: String by settings

    plugins {
        id("org.jetbrains.kotlin.jvm") version kotlin_version
        id("com.github.johnrengelman.shadow") version "5.2.0"
        id("com.jfrog.bintray") version "1.8.5"
        id("com.gradle.plugin-publish") version "0.12.0"
    }

    repositories {
        maven(dokka_jcenter_repository)
        gradlePluginPortal()
        mavenCentral()
        maven(dokka_kotlin_eap_repository)
        maven(dokka_kotlin_dev_repository)
    }

}

