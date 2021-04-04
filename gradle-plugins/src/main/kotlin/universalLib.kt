import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinAndroidTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinWithJavaTarget
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsBrowserDsl
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsNodeDsl
import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinJsTargetDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget

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

fun KotlinAndroidTarget.library(java: String = "1.8") {
    targetJava(java)
    publishLibraryVariants("release")
}

fun KotlinAndroidTarget.application(java: String = "1.8") {
    targetJava(java)
}

fun KotlinJvmTarget.library(java: String = "1.8") {
    targetJava(java)
}

fun KotlinWithJavaTarget<KotlinJvmOptions>.library(java: String = "1.8") {
    targetJava(java)
}

fun KotlinWithJavaTarget<KotlinJvmOptions>.application(java: String = "1.8") {
    targetJava(java)
}

fun KotlinJvmTarget.application(java: String = "1.8") {
    targetJava(java)
}

/**
 * @param testTimeout in milliseconds, set to null to disable testing
 */
fun KotlinJsTargetDsl.browserLib(testTimeout: Int? = 10000, config: (KotlinJsBrowserDsl.() -> Unit)? = null) {
    if (testTimeout != null) project.createKarmaTimeoutFile(testTimeout)
    browser {
        if (testTimeout == null) testTask { enabled = false }
        if (config != null) config()
    }
}

/**
 * @param testTimeout in milliseconds, set to null to disable testing
 */
fun KotlinJsTargetDsl.browserApp(testTimeout: Int? = null, config: (KotlinJsBrowserDsl.() -> Unit)? = null) {
    browserLib(testTimeout) {
        commonWebpackConfig {
            cssSupport.enabled = true
            outputFileName = "main.bundle.js"
            devServer = KotlinWebpackConfig.DevServer(
                open = false,
                contentBase = listOf(project.file("build/processedResources/js/main").absolutePath)
            )
        }
        if (config != null) config()
    }
    binaries.executable()
}

/**
 * @param testTimeout in milliseconds, set to null to disable testing
 */
fun KotlinJsTargetDsl.nodeLib(testTimeout: Int? = 10000, config: (KotlinJsNodeDsl.() -> Unit)? = null) {
    nodejs {
        testTask {
            if (config != null) config()
            if (testTimeout != null) useMocha {
                this.timeout = "${testTimeout}ms"
            } else enabled = false
        }
    }
}

fun KotlinJsTargetDsl.nodeApp(testTimeout: Int? = null, config: (KotlinJsNodeDsl.() -> Unit)? = null) {
    nodeLib(testTimeout, config)
    binaries.executable()
}


fun KotlinJsTargetDsl.library(testTimeout: Int? = 10000, config: (KotlinJsTargetDsl.() -> Unit)? = null) {
    browser()
    nodejs()
    if (testTimeout != null) enableTesting(testTimeout, forBrowser = true, forNodeJs = true)
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

    if (forAndroid) android { targetJava() }
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