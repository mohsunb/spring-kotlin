package com.example.kotlinspringdemo.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.Date

data class StudentDto(
    var firstName: String?,
    var lastName: String?,
    @JsonFormat(pattern = "yyyy-MM-dd")
    var dateOfBirth: Date?
) {
    constructor() : this(null, null, null)
}
