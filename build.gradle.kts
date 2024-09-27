plugins {
    `java-library`
    id("com.gradleup.shadow") version "8.3.0"
}

group = "at.helpch.placeholderapi.expansion"
version = "2.7.3"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.6")
}

tasks {
    jar {
        manifest {
            attributes["Implementation-Title"] = "server"
            attributes["Implementation-Version"] = project.version
        }
    }

    java {
        disableAutoTargetJvm()
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    shadowJar {
        archiveFileName.set("PAPI-Expansion-Server-${project.version}.jar")
    }
}
