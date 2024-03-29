plugins {
    id("com.android.library") version "7.1.0-alpha03"
    kotlin("multiplatform") version "1.5.10"
    id("io.codearte.nexus-staging") version "0.22.0"
    id("tz.co.asoft.library")
    signing
}

group = "tz.co.asoft"
version = versions.asoft.builders

kotlin {
    android { library() }
    jvm { library() }
    js(IR) { library() }
    macosX64()
    ios()
    tvos()
    linuxX64()
    linuxArm64()
    linuxArm32Hfp()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(asoft("kotlinx-serialization-mapper", versions.asoft.mapper))
            }
        }
    }
}

aSoftOSSLibrary(
    version = versions.asoft.builders,
    description = "A Library to help reading configurations"
)