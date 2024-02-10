package com.example.kotlinspringdemo.mapper

import com.example.kotlinspringdemo.dto.StudentDto
import com.example.kotlinspringdemo.entity.Student

class StudentMapper {
    fun mapDtoToEntity(dto: StudentDto): Student {
        return Student(null, dto.firstName, dto.lastName, dto.dateOfBirth)
    }

    fun mapEntityToDto(entity: Student): StudentDto {
        return StudentDto(entity.firstName, entity.lastName, entity.dateOfBirth)
    }
}
