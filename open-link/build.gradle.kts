import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.chromaticnoise.multiplatform-swiftpackage-m1-support")
}

// this function configures your generated Swift package
multiplatformSwiftPackage {
    xcframeworkName("OpenLink") // you can define your name for the generated framework otherwise it takes default name from module
    swiftToolsVersion("5.3") // swift tool version required by the generated package
    targetPlatforms {
        iOS { v("13") } // defines the platform + OS version the framework support
    }
    outputDirectory(File(projectDir, "openlink")) // define the name and location of output folder of the swift package
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }
        publishLibraryVariants("release", "debug")
    }
    
    val xcf = XCFramework("OpenLink")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "OpenLink"
            xcf.add(this)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.niranjan.khatri.open_link"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}