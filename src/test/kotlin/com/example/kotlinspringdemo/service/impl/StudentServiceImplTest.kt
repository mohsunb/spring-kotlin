package com.example.kotlinspringdemo.service.impl

import com.example.kotlinspringdemo.dto.StudentDto
import com.example.kotlinspringdemo.entity.Student
import com.example.kotlinspringdemo.exception.NotFoundException
import com.example.kotlinspringdemo.mapper.StudentMapper
import com.example.kotlinspringdemo.repository.StudentRepository
import com.example.kotlinspringdemo.service.StudentService
import java.util.Optional
import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest(classes = [StudentServiceImpl::class])
class StudentServiceImplTest {
    @MockBean
    lateinit var repository: StudentRepository

    @MockBean
    lateinit var mapper: StudentMapper

    @Autowired
    lateinit var service: StudentService

    @Test
    fun getAllStudentsSuccess() {
        service.getAllStudents()
        verify(repository, times(1)).findAll()
    }

    @Test
    fun getStudentByIdSuccess() {
        `when`(repository.findById(Mockito.anyLong()))
            .thenReturn(Optional.of(Student()))
        service.getStudentById(1L)
        verify(repository, times(1)).findById(1L)
        verify(mapper, times(1)).mapEntityToDto(Student())
    }

    @Test
    fun getStudentByIdWhenNotFoundThenThrow() {
        `when`(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty())
        AssertionsForClassTypes.assertThatThrownBy { service.getStudentById(1L) }
            .isInstanceOf(NotFoundException::class.java)
    }

    @Test
    fun addStudentSuccess() {
        `when`(mapper.mapDtoToEntity(StudentDto())).thenReturn(Student())
        service.addStudent(StudentDto())
        verify(repository, times(1)).save(Student())
    }
}
