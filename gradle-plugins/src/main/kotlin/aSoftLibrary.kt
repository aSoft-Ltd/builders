import org.gradle.api.Project

fun Project.aSoftLibrary(
    version: String,
    description: String,
    url: String = "https://github.com/aSoft-Ltd/$name",
    scmConnection: String = "scm:git:git://github.com/aSoft-Ltd/$name.git",
    scmDeveloperConnection: String = "scm:git:https://github.com/aSoft-Ltd/$name.git",
    licenseName: String = "MIT License",
    licenseUrl: String = "https://github.com/aSoft-Ltd/$name/blob/master/LICENSE",
    developerId: String = "andylamax",
    developerName: String = "Anderson Lameck"
) = KotlinLibrary(
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