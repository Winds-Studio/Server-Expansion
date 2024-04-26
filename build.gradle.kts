plugins {
    `java-library`
    id("io.github.goooler.shadow") version "8.1.7"
}

group = "at.helpch.placeholderapi.expansion"
version = "2.7.0"

repositories {
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.5")
}

tasks {
    shadowJar {
        archiveFileName.set("PAPI-Expansion-Server-${project.version}.jar")
    }
}
