buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlin.pluginGradle)
        classpath(libs.android.pluginGradle)
        classpath(libs.hilt.android.pluginGradle)
        classpath(libs.sqldelight.pluginGradle)
    }
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
