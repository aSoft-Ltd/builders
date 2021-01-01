plugins {
    id("com.android.application") version "4.1.0"
    kotlin("android") version "1.4.21"
    id("tz.co.asoft.applikation")
}

android {
    configureAndroid("src/main")
    defaultConfig {
        minSdk = 18
    }
}

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

//    staging(
//        "link" to "https://staging.com"
//    )

    release(
        "link" to "https://release.com"
    )
}

kotlin {
    target { targetJava("1.8") }
    sourceSets {
        val main by getting {
            dependencies {
                implementation("tz.co.asoft:applikation-runtime:1.3.0")
            }
        }
    }
}