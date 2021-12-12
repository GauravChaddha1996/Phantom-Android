// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    kotlin("jvm") version "1.5.31"
}

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

