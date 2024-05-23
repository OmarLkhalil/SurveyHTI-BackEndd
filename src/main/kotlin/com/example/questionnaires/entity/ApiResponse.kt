package com.example.questionnaires.entity

data class ApiResponse<T>(
    val msg: String,
    val response: T?,
    val status: Int
)