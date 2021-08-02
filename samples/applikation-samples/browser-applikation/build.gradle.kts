plugins {
    kotlin("js") version "1.5.10"
    id("tz.co.asoft.applikation")
}

repositories {
    google()
    jcenter()
}

group = "tz.co.asoft"
version = "2020.2"

applikation {
    debug(
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
    js(IR) {
        browserApp(testTimeout = 10000)
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation("tz.co.asoft:applikation-runtime:0.0.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
                implementation("org.jetbrains:kotlin-react:17.0.0-pre.129-kotlin-1.4.20")
                implementation("org.jetbrains:kotlin-styled:5.2.0-pre.129-kotlin-1.4.20")
                implementation("org.jetbrains:kotlin-react-dom:17.0.0-pre.129-kotlin-1.4.20")
            }
        }

        val test by getting {
            dependencies {
                implementation(asoft("expect-core", "0.0.40"))
            }
        }
    }
}