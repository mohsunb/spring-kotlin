package com.example.kotlinspringdemo.exception

import java.lang.RuntimeException

class NotFoundException(message: String): RuntimeException(message)
