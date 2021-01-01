plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

group = "tz.co.asoft"
version = "2020.2"

kotlin {
    multiplatformLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(asoft("applikation-runtime", "1.2.0"))
            }
        }
    }
}