plugins {
    id("com.android.application") version "4.1.0"
    kotlin("android") version "1.4.10"
    id("tz.co.asoft.applikation")
}

repositories {
    google()
    jcenter()
}

android {
    configureAndroid("src/main")
    defaultConfig {
        minSdk = 18
    }
}

targetJava("1.8")

group = "tz.co.asoft"
version = "2020.2"

applikation {
    debug(
        "change" to 1,
        "authors" to mapOf(
            "architecture" to "andylamax@programmer.net"
        ),
        "link" to "http://debug.com"
    )

    staging(
        "link" to "https://staging.com"
    )

    release(
        "link" to "https://release.com"
    )
}

dependencies {
    implementation("tz.co.asoft:applikation-runtime:0.0.1")
}