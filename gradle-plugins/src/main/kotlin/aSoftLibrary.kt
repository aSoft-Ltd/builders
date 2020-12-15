import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension

fun Project.aSoftCSSLibrary(
    version: String,
    config: PublishingExtension.() -> Unit = {}
) = KotlinLibrary("tz.co.asoft", version, config)

fun Project.aSoftOSSLibrary(
    version: String,
    description: String,
    url: String = "https://github.com/aSoft-Ltd/$name",
    scmConnection: String = "scm:git:git://github.com/aSoft-Ltd/$name.git",
    scmDeveloperConnection: String = "scm:git:https://github.com/aSoft-Ltd/$name.git",
    licenseName: String = "MIT License",
    licenseUrl: String = "https://github.com/aSoft-Ltd/$name/blob/master/LICENSE",
    developerId: String = "andylamax",
    developerName: String = "Anderson Lameck"
) = MavenLibrary(
    "tz.co.asoft",
    version,
    description,
    url,
    scmConnection,
    scmDeveloperConnection,
    licenseName,
    licenseUrl,
    developerId,
    developerName
)