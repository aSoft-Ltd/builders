plugins {
    id("com.android.library") version "4.1.0"
    kotlin("multiplatform") version "1.4.20"
    id("io.codearte.nexus-staging") version "0.22.0"
    id("tz.co.asoft.library")
    signing
}

object vers {
    object asoft {
        val builders = "1.1.1"
        val mapper = "0.0.1"
    }
}

kotlin {
    universalLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("tz.co.asoft:kotlinx-serialization-mapper:${vers.asoft.mapper}")
            }
        }
    }
}

aSoftLibrary(
    version = vers.asoft.builders,
    description = "A Library to help reading configurations"
)