package com.example.kotlinspringdemo.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(schema = "test_db", name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var firstName: String?,
    var lastName: String?,
    var dateOfBirth: Date?
)
