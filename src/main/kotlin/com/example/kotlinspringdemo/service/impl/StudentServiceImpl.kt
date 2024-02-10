package com.example.kotlinspringdemo.service.impl

import com.example.kotlinspringdemo.dto.StudentDto
import com.example.kotlinspringdemo.exception.NotFoundException
import com.example.kotlinspringdemo.mapper.StudentMapper
import com.example.kotlinspringdemo.repository.StudentRepository
import com.example.kotlinspringdemo.service.StudentService
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(val repository: StudentRepository, val mapper: StudentMapper) : StudentService {
    override fun getAllStudents(): List<StudentDto> = repository.findAll().map { mapper.mapEntityToDto(it) }

    override fun getStudentById(id: Long): StudentDto {
        return mapper.mapEntityToDto(
            repository.findById(id).orElse(null) ?: throw NotFoundException("Student with ID '$id' not found"))
    }

    override fun addStudent(request: StudentDto) {
        repository.save(mapper.mapDtoToEntity(request))
    }
}
