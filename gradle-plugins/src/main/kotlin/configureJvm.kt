import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinWithJavaTarget
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget

fun KotlinJvmTarget.targetJava(version: String = "1.8") = compilations.all {
    kotlinOptions {
        jvmTarget = version
        useIR = true
        freeCompilerArgs = listOf("-Xallow-unstable-dependencies")
    }
}

fun KotlinWithJavaTarget<KotlinJvmOptions>.targetJava(version: String = "1.8") {
    compilations.all {
        kotlinOptions {
            jvmTarget = version
            useIR = true
            freeCompilerArgs = listOf("-Xallow-unstable-dependencies")
        }
    }
}