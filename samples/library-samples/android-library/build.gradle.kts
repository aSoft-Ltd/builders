plugins {
    id("com.android.library") version "4.1.3"
    kotlin("android") version "1.5.0"
    id("tz.co.asoft.library")
}

group = "tz.co.asoft"
version = "0.0.1"

kotlin {
    target { library() }
}

configurePublishing { }