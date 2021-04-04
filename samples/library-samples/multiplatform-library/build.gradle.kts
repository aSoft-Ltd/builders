plugins {
    id("com.android.library") version "4.1.3"
    kotlin("multiplatform") version "1.4.31"
    id("tz.co.asoft.library")
}

group = "tz.co.asoft"
version = "0.0.1"

kotlin {
    android { library() }
    jvm { library() }
    js(IR) { library() }
    macosX64()
    ios()
    tvos()
    linuxX64()
    linuxArm64()
}