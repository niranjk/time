plugins {
    id(androidApp)
    kotlin(androidPlugin)
}

android {
    namespace = "com.niranjan.khatri.time.android"
    compileSdk = Versions.compile_sdk
    defaultConfig {
        applicationId = "com.niranjan.khatri.time.android"
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler_version
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(mapOf("path" to ":open-link")))
    with(Deps){
        implementation(Deps.napier)
    }

    with(Deps.Compose){
        implementation(ui)
        implementation(tooling)
        implementation(preview)
        implementation(foundation)
        implementation(material)
        implementation(activity)
        implementation(navigation)
    }
}