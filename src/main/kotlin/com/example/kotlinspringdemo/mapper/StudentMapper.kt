package com.example.kotlinspringdemo.mapper

import com.example.kotlinspringdemo.dto.StudentDto
import com.example.kotlinspringdemo.entity.Student
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class StudentMapper {
    abstract fun mapEntityToDto(entity: Student): StudentDto

    abstract fun mapDtoToEntity(dto: StudentDto): Student
}
