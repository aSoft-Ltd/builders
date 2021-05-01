plugins {
    id("com.android.library") version "4.1.3"
    kotlin("multiplatform") version "1.5.0"
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