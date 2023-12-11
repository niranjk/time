pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
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
include(":open-link")  // remove this : add only when publishing again
includeBuild("plugins/multiplatform-swiftpackage-m1_support") // remove this
