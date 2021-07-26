plugins {
    id("com.android.library") version "7.1.0-alpha03"
    kotlin("multiplatform") version "1.5.21"
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging") version "0.22.0"
    signing
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

configurePublishing {

}