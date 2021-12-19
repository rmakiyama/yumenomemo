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
        classpath(libs.detekt)
        classpath(libs.kermit.pluginGradle)
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
