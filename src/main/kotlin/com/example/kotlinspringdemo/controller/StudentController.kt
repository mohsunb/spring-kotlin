package com.example.kotlinspringdemo.controller

import com.example.kotlinspringdemo.dto.StudentDto
import com.example.kotlinspringdemo.entity.Student
import com.example.kotlinspringdemo.service.StudentService
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
class StudentController(val service: StudentService) {
    @GetMapping
    fun getAllStudents(): ResponseEntity<List<StudentDto>> = ResponseEntity.ok(service.getAllStudents())

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<StudentDto> = ResponseEntity.ok(service.getStudentById(id))

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addStudent(@RequestBody request: StudentDto) {
        service.addStudent(request)
    }
}
