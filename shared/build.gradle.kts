plugins {
    kotlin(multiplatform)
    kotlin(cocoapods)
    id(androidLib)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    // 1 used to define android target
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    // 2 defines target for iOS
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    // 3
    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    // 4
    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(Deps.JetBrains.datetime)
                implementation(Deps.napier)
                // implementation(project(":open-link")) // add this for publishing to maven central
                // implementation("com.niranjan.khatri.shared:open-link:1.0") // add this for maven local
                // Note* Uncomment for OpenLinkApp Test
                // implementation("com.niranjan.khatri.shared:open-link:1.0") // add this dependencies from github packages
            }
        }
        val commonTest by getting {
            dependencies {
            }
        }
    }
}

android {
    namespace = "com.niranjan.khatri.time"
    compileSdk = Versions.compile_sdk
    defaultConfig {
        minSdk = Versions.min_sdk
    }
}