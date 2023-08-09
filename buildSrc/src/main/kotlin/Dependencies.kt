
// define all plugin names:

const val androidPlugin = "android"
const val androidApp = "com.android.application"
const val androidLib = "com.android.library"
const val multiplatform = "multiplatform"
const val composePlugin = "org.jetbrains.compose"
const val cocoapods = "native.cocoapods"


object  Versions {
    // 1
    const val min_sdk = 24
    const val target_sdk = 33
    const val compile_sdk = 33

    // 2 Plugins
    const val compose_compiler_version = "1.4.3"
    const val compose_version = "1.4.3"
    const val compose_activity_version = "1.7.1"
    const val desktop_compose_plugin = "1.0.1"

    // coroutines, junit
    // multiplatform loggin library
    const val napier = "2.1.0"
    const val junit = "4.13.2"
    const val kotlinxDateTime = "0.3.1"
    const val junit5 = "1.5.10"
    const val coroutines = "1.6.0-native-mt"

}

object Deps{

    const val napier = "io.github.aakira:napier:${Versions.napier}"

    object Compose {
        const val ui = ("androidx.compose.ui:ui:${Versions.compose_version}")
        const val tooling = ("androidx.compose.ui:ui-tooling:${Versions.compose_version}")
        const val preview = ("androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}")
        const val foundation = ("androidx.compose.foundation:foundation:${Versions.compose_version}")
        const val material = ("androidx.compose.material:material:${Versions.compose_version}")
        const val activity = ("androidx.activity:activity-compose:${Versions.compose_activity_version}")
    }

    // Coroutines
    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    // Jetbrains
    object JetBrains {
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"
        const val uiDesktop = "org.jetbrains.compose.ui:ui-desktop:${Versions.desktop_compose_plugin}"
        const val uiUtil = "org.jetbrains.compose.ui:ui-util:${Versions.desktop_compose_plugin}"
    }
}
