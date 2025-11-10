plugins {
    kotlin("jvm") version "2.0.0"
    id("application")
    id("io.ktor.plugin") version "3.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:3.0.0")
    implementation("io.ktor:ktor-server-netty-jvm:3.0.0")
    implementation("ch.qos.logback:logback-classic:1.5.12")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("com.example.ApplicationKt")
}

tasks.matching { it.name == "fatJar" || it.name == "buildFatJar" }.configureEach {
    (this as? org.gradle.jvm.tasks.Jar)?.archiveFileName?.set("app.jar")
}

ktor {
    fatJar {
        archiveFileName.set("app.jar")
    }
}

tasks.named("jar").configure {
    enabled = false

}
