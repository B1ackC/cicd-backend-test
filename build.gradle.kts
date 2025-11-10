plugins {
    kotlin("jvm") version "2.0.0"
    id("application")                 // ← 추가
    id("io.ktor.plugin") version "3.0.0"
}

repositories { mavenCentral() }

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:3.0.0")
    implementation("io.ktor:ktor-server-netty-jvm:3.0.0")
    implementation("ch.qos.logback:logback-classic:1.5.12")
}

// 메인 클래스 지정 (패키지+Kt 주의)
application {
    mainClass.set("com.example.ApplicationKt")
}
