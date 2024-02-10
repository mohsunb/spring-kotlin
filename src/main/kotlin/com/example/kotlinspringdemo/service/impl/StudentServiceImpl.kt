package com.example.kotlinspringdemo.service.impl

import com.example.kotlinspringdemo.dto.StudentDto
import com.example.kotlinspringdemo.mapper.StudentMapper
import com.example.kotlinspringdemo.repository.StudentRepository
import com.example.kotlinspringdemo.service.StudentService
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(val repository: StudentRepository) : StudentService {
    val mapper = StudentMapper()

    override fun getAllStudents(): List<StudentDto> = repository.findAll().map { mapper.mapEntityToDto(it) }

    override fun getStudentById(id: Long): StudentDto = mapper.mapEntityToDto(repository.findById(id).orElseThrow())

    override fun addStudent(request: StudentDto) {
        repository.save(mapper.mapDtoToEntity(request))
    }
}
