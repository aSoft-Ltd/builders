plugins {
    kotlin("js") version "1.5.0"
    id("tz.co.asoft.library")
}

val lib_version = "0.0.1"
group = "tz.co.asoft"
version = lib_version

kotlin {
    js(IR) { library() }
}

KotlinLibrary(
    group = "tz.co.asoft",
    version = lib_version
) {}