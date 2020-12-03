pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}

includeBuild("../../../gradle-plugins")
include(":applikation-runtime")
project(":applikation-runtime").projectDir = File("../../../applikation-runtime")
