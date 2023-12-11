plugins {
    //trick: for the same plugin versions in all sub-modules
    id(androidApp).version("8.1.2").apply(false)
    id(androidLib).version("8.1.2").apply(false)
    kotlin(androidPlugin).version("1.9.10").apply(false)
    kotlin(multiplatform).version("1.9.10").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/niranjk/time/open-link")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}
