import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/**
 * @param testTimeout (in milliseconds) if null the test wont be configure
 */
fun KotlinMultiplatformExtension.multiplatformApplication(
    forAndroid: Boolean = true,
    forJvm: Boolean = true,
    withJava: Boolean = false,
    forBrowser: Boolean = true,
    forNodeJs: Boolean = false,
    testTimeout: Int? = null
) {
    if (forAndroid && withJava) throw Exception("You can't have forAndroid=true and withJava=true")

    if (forAndroid) android {
        targetJava("1.8")
    }

    if (forJvm) jvm {
        targetJava("1.8")
        if (withJava) withJava()
    }

    if (forBrowser || forNodeJs) js(IR) {
        application(testTimeout, forNodeJs)
    }
}

/**
 * @param testTimeout if set to 0, testing will not be enabled
 */
fun KotlinMultiplatformExtension.multiplatformLib(
    forAndroid: Boolean = false,
    forJvm: Boolean = true,
    withJava: Boolean = false,
    forBrowser: Boolean = true,
    forNodeJs: Boolean = true,
    testTimeout: Int = 10000
) {
    if (forAndroid && withJava) throw Exception("You can not use withJava=true and forAndroid=true")

    if (forAndroid) android {
        targetJava("1.8")
        publishLibraryVariants("release")
    }
    if (forJvm) jvm {
        targetJava("1.8")
        if (withJava) withJava()
    }
    if (forBrowser || forNodeJs) js(IR) {
        if (forBrowser) browser()
        if (forNodeJs) nodejs()
        if (testTimeout >= 0) enableTesting(testTimeout, forBrowser = forBrowser, forNodeJs = forNodeJs)
    }
}