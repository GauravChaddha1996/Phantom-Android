// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    // Telling gradle to find our dependencies in those repositories
    repositories {
        google()
        mavenCentral()
    }

    // Telling gradle to depend on these plugins
    // 1. android-gradle-plugin that helps gradle do android specific stuff
    // 2. kotlin-gradle-plugin that helps gradle do kotlin compilation related stuff
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}

// Tell which version of kotlin we want to use
plugins {
    kotlin("jvm") version "1.5.31"
}

// Custom tasks for pre-commit hook
tasks.register<Copy>("copyGitHooks") {
    from(layout.projectDirectory.file("scripts/pre-commit.sh"))
    into(layout.projectDirectory.dir(".git/hooks"))
    fileMode = 777
    rename { it.removeSuffix(".sh") }
    doLast {
        project.exec {
            commandLine("chmod", "+x", layout.projectDirectory.file(".git/hooks/pre-commit"))
        }
    }
}

