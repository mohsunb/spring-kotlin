package com.example.kotlinspringdemo.controller

import com.example.kotlinspringdemo.dto.StudentDto
import com.example.kotlinspringdemo.entity.Student
import com.example.kotlinspringdemo.service.StudentService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/student")
@Tag(name = "Student Controller", description = "Simple operations with 'Student' entity")
class StudentController(val service: StudentService) {
    @GetMapping
    @Operation(summary = "Get all students")
    fun getAllStudents(): ResponseEntity<List<StudentDto>> = ResponseEntity.ok(service.getAllStudents())

    @GetMapping("/{id}")
    @Operation(summary = "Get a student by their ID")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<StudentDto> = ResponseEntity.ok(service.getStudentById(id))

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new student")
    fun addStudent(@RequestBody request: StudentDto) {
        service.addStudent(request)
    }
}
