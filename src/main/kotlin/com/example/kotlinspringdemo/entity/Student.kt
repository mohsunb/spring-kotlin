package com.example.kotlinspringdemo.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(schema = "test_db", name = "students")
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    var firstName: String?,
    var lastName: String?,
    var dateOfBirth: Date?
) {
    constructor() : this(null, null, null, null)
}
