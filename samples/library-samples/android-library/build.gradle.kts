plugins {
    id("com.android.library") version "7.1.0-alpha03"
    kotlin("android") version "1.5.21"
    id("tz.co.asoft.library")
}

group = "tz.co.asoft"
version = "0.0.1"

kotlin {
    target { library() }
}

configurePublishing { }