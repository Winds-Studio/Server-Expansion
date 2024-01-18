plugins {
    `java-library`
}

group = "com.extendedclip.papi.expansion.server"
version = "2.6.2"
description = "PlaceholderAPI expansion for server placeholders"

repositories {
    mavenCentral()

    maven {
        name = "paper-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }

    maven {
        name = "placeholderapi"
        url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    }
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.5") {
        exclude(group = "org.bstats")
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
