import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
    id("org.jetbrains.kotlin.kapt") version "1.9.22"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    id("jacoco")
    id("org.sonarqube") version "4.4.1.3373"
}

group = "com.example"
version = "0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

/* Dependency versions */
val openApiVersion = "2.3.0"
val mapstructVersion = "1.5.5.Final"
val logbackEncoderVersion = "7.4"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.liquibase:liquibase-core")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$openApiVersion")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    implementation("net.logstash.logback:logstash-logback-encoder:$logbackEncoderVersion")

    kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")

    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
    }
}

sonarqube {
    properties {
        property("sonar.scm.forceReloadAll", true)
        property("sonar.gradle.skipCompile", true)
        property(
            "sonar.coverage.exclusions", "**/com/example/kotlinspringdemo/*," +
                    "**/com/example/kotlinspringdemo/controller/*," +
                    "**/com/example/kotlinspringdemo/dto/**," +
                    "**/com/example/kotlinspringdemo/entity/*," +
                    "**/com/example/kotlinspringdemo/exception/*," +
                    "**/com/example/kotlinspringdemo/handler/*," +
                    "**/com/example/kotlinspringdemo/mapper/**," +
                    "**/com/example/kotlinspringdemo/repository/*"
        )
    }
}
