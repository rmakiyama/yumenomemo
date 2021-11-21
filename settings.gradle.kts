pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "yumenomemo"
include(":android")
include(":shared")

enableFeaturePreview("VERSION_CATALOGS")
