import java.util.Properties
import kotlin.apply

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

val localProperties = Properties().apply {
    val localPropertiesFile = File(rootDir, "local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.inputStream().use { load(it) }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/kei-1111/kmp-sample-library")
            credentials {
                username = localProperties.getProperty("gpr.user") ?: System.getenv("GITHUB_ACTOR")
                password = localProperties.getProperty("gpr.token") ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

rootProject.name = "kmp-sample-android"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
includeBuild("build-logic")
include(":app")
include(":core:designsystem")
include(":feature:home")
 