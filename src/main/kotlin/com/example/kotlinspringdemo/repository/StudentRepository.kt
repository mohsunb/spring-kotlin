package com.example.kotlinspringdemo.repository

import com.example.kotlinspringdemo.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long>
