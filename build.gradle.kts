import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val mongodb_version: String by project


plugins {
    kotlin("jvm") version "1.8.20"
    kotlin("plugin.serialization") version "1.8.20"
    id("io.ktor.plugin") version "2.2.4"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}



repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-resources:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")

    //mongoDB
    implementation("org.mongodb:mongodb-driver-sync:$mongodb_version")
    implementation("org.mongodb:mongodb-driver-kotlin-coroutine:$mongodb_version")
    implementation("org.mongodb:bson-kotlinx:$mongodb_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")


    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")

    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}


kotlin {
    jvmToolchain(17)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
        javaParameters.set(true)
        languageVersion.set(KotlinVersion.KOTLIN_1_8)
    }
}
