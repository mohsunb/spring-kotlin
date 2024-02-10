package com.example.kotlinspringdemo.service

import com.example.kotlinspringdemo.dto.StudentDto

interface StudentService {
    fun getAllStudents(): List<StudentDto>

    fun getStudentById(id: Long): StudentDto

    fun addStudent(request: StudentDto)
}
