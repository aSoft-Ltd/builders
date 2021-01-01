plugins {
    kotlin("jvm") version "1.4.21"
    id("tz.co.asoft.applikation")
}

group = "tz.co.asoft"
version = "2021.1"

application {
    mainClassName = "tz.co.asoft.MainKt"
}

data class Person(val name: String, val age: Int) : java.io.Serializable
applikation {
    common(
        "Main-Class" to "tz.co.asoft.MainKt",
        "devs" to listOf(
            Person(name = "Andy", age = 30),
            Person(name = "Lamax", age = 30)
        )
    )

    debug(
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
    target {
        targetJava("1.8")
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation("tz.co.asoft:applikation-runtime:${versions.asoft_builders}")
            }
        }
    }
}