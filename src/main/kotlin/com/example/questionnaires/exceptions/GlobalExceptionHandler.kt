package com.example.questionnaires.exceptions

import com.example.questionnaires.entity.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [NoSuchElementException::class])
    fun handleNotFound(exception: NoSuchElementException): ResponseEntity<ApiResponse<Nothing>> {
        val apiResponse = ApiResponse("Resource not found", null, 404)
        return ResponseEntity(apiResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [Exception::class])
    fun handleGenericException(exception: Exception): ResponseEntity<ApiResponse<Nothing>> {
        val apiResponse = ApiResponse("An error occurred", null, 500)
        return ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}