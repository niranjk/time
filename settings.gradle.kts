pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Time"
include(":androidApp")
include(":shared")
include(":open-link")
includeBuild("plugins/multiplatform-swiftpackage-m1_support")
