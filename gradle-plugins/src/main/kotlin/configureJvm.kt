import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinWithJavaCompilation
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinWithJavaTarget
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun KotlinJvmTarget.targetJava(version: String = "1.8") = compilations.all {
    kotlinOptions {
        jvmTarget = version
        useIR = true
    }
}

fun KotlinWithJavaTarget<KotlinJvmOptions>.targetJava(version: String = "1.8") {
    compilations.all {
        kotlinOptions {
            jvmTarget = version
            useIR = true
        }
    }
}