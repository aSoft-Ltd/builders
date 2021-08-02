plugins {
    kotlin("js") version "1.5.10"
    id("tz.co.asoft.library")
}

val lib_version = "0.0.1"
group = "tz.co.asoft"
version = lib_version

kotlin {
    js(IR) { library() }

    sourceSets {
        val test by getting {
            dependencies {
                api(asoft("expect-core", "0.0.40"))
            }
        }
    }
}

KotlinLibrary(
    group = "tz.co.asoft",
    version = lib_version
) {}