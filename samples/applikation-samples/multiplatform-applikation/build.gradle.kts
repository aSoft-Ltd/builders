plugins {
    id("com.android.application") version "4.1.3"
    kotlin("multiplatform") version "1.4.31"
    id("tz.co.asoft.applikation")
}

android {
    configureAndroid("src/androidMain")
    defaultConfig {
        minSdk = 18
    }

    buildTypes {
        val debug by getting {
            setApplicationIdSuffix("debug")
            manifestPlaceholders(mapOf("appName" to "Konfig Test Debug"))
            minifyEnabled(false)
        }
        val staging by creating {
            setApplicationIdSuffix("staging")
            initWith(debug)
            minifyEnabled(false)
            manifestPlaceholders(mapOf("appName" to "Konfig Test Staging"))
            setMatchingFallbacks("release")
        }
        val release by getting {
            initWith(debug)
            minifyEnabled(false)
            manifestPlaceholders(mapOf("appName" to "Konfig"))
            setMatchingFallbacks("release")
        }
    }
}

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
    android { application() }
    jvm { application() }
    js(IR) { application() }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("tz.co.asoft:applikation-runtime:1.3.20")
            }
        }

        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
                implementation("org.jetbrains:kotlin-react:17.0.0-pre.129-kotlin-1.4.20")
                implementation("org.jetbrains:kotlin-styled:5.2.0-pre.129-kotlin-1.4.20")
                implementation("org.jetbrains:kotlin-react-dom:17.0.0-pre.129-kotlin-1.4.20")
            }
        }

        val jsTest by getting {
            dependencies {
                implementation("tz.co.asoft:test-coroutines:1.1.10")
            }
        }
    }
}