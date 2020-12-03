plugins {
    id("com.android.application") version "4.1.0"
    kotlin("multiplatform") version "1.4.20"
    id("tz.co.asoft.applikation")
}

repositories {
    google()
    jcenter()
}

android {
    configureAndroid("src/androidMain")
    defaultConfig {
        minSdk = 18
    }
}

targetJava("1.8")

group = "tz.co.asoft"
version = "2020.2"

applikation {
    common(
        "Main-Class" to "tz.co.asoft.MainKt"
    )
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

kotlin {
    android {
        targetJava("1.8")
    }

    jvm {
        targetJava("1.8")
    }

    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("tz.co.asoft:applikation-runtime:0.0.1")
            }
        }

        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
                implementation("org.jetbrains:kotlin-react:17.0.0-pre.129-kotlin-1.4.10")
                implementation("org.jetbrains:kotlin-styled:5.2.0-pre.129-kotlin-1.4.10")
                implementation("org.jetbrains:kotlin-react-dom:17.0.0-pre.129-kotlin-1.4.10")
            }
        }
    }
}