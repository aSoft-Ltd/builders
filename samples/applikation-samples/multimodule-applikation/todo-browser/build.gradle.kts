plugins {
    kotlin("js")
    id("tz.co.asoft.applikation")
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
    js(IR) { application() }

    sourceSets {
        val main by getting {
            dependencies {
                implementation(project(":todo-core"))
                implementation(asoft("reakt-core", "0.1.10"))
            }
        }

        val test by getting {
            dependencies {
                api(asoft("expect-core", "0.0.40"))
                api(asoft("test-coroutines", "1.1.32"))
            }
        }
    }
}
