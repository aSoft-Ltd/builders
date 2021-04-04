plugins {
    id("com.android.library") version "4.1.3"
    kotlin("multiplatform") version "1.4.31"
    id("io.codearte.nexus-staging") version "0.22.0"
    id("tz.co.asoft.library")
    signing
}

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