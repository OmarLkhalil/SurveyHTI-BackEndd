package com.example.questionnaires.entity

import com.example.questionnaires.model.Doctor

data class ApiResponse<T>(
    val msg: String,
    val response: T?,
    val status: Int
)

data class DepartmentDetailsResponse(
    val id: Long,
    val name: String,
    val rate1: Int,
    val rate2: Int,
    val rate3: Int,
    val description: String,
    val doctors: List<Doctor>
)
