plugins {
    id("com.android.library") version "4.1.0"
    kotlin("multiplatform") version "1.4.21"
    id("io.codearte.nexus-staging") version "0.22.0"
    id("tz.co.asoft.library")
    signing
}

kotlin {
    multiplatformLib(forAndroid = true)
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(asoft("kotlinx-serialization-mapper", versions.asoft_mapper))
            }
        }
    }
}

aSoftOSSLibrary(
    version = versions.asoft_builders,
    description = "A Library to help reading configurations"
)