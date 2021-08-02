plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

group = "tz.co.asoft"
version = "2020.2"

kotlin {
    android { library() }
    jvm { library() }
    js(IR) { library() }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(asoft("applikation-runtime", "1.2.0"))
            }
        }

        val commonTest by getting {
            dependencies {
                api(asoft("expect-core", "0.0.40"))
                api(asoft("test-coroutines", "1.1.32"))
            }
        }
    }
}