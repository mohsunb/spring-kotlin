package com.example.kotlinspringdemo

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
    info =
        Info(
            title = "Spring Kotlin Demo",
            description = "A simple Spring Boot demo application written in Kotlin",
            version = "0.1"
        )
)
class KotlinSpringDemoApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringDemoApplication>(*args)
}
