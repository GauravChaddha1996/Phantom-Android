/* Gradle configs for the project resides here */

// Include gradle enterprise plugin to ensure we can publish build scans
plugins {
    id("com.gradle.enterprise") version ("3.8.1")
}
// Accepting the Gradle enterprise tos
gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

// Telling gradle the project it'll build and the modules to include
rootProject.name = "Phantom"
include(":app")


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}