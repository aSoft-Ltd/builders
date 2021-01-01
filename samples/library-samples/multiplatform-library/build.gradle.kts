plugins {
    id("com.android.library") version "4.1.0"
    kotlin("multiplatform") version "1.4.21"
    id("tz.co.asoft.library")
}

group = "tz.co.asoft"
version = "0.0.1"

kotlin {
    multiplatformLib(forAndroid = true)
}