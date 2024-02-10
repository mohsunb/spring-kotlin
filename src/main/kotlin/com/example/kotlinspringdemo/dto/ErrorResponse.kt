package com.example.kotlinspringdemo.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ErrorResponse(
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    val timestamp: LocalDateTime,
    val status: Short,
    val error: String,
    val message: String?,
    val path: String
)
