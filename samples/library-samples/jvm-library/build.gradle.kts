plugins {
    kotlin("jvm") version "1.5.10"
    id("tz.co.asoft.library")
}

group = "tz.co.asoft"
version = "0.0.1"

kotlin {
    target {
        library()
    }
}
configurePublishing {}