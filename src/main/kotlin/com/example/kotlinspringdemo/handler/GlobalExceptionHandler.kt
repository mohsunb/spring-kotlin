package com.example.kotlinspringdemo.handler

import com.example.kotlinspringdemo.dto.ErrorResponse
import com.example.kotlinspringdemo.exception.NotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException, httpRequest: HttpServletRequest):
            ResponseEntity<ErrorResponse> {
        val httpStatus = HttpStatus.NOT_FOUND
        return ResponseEntity.status(httpStatus).body(ErrorResponse(
                LocalDateTime.now(),
                httpStatus.value().toShort(),
                httpStatus.reasonPhrase,
                exception.message,
                httpRequest.requestURI))
    }
}
