package com.example.questionnaires.repo

import com.example.questionnaires.model.Doctor
import org.springframework.data.jpa.repository.JpaRepository


interface DoctorRepository : JpaRepository<Doctor, Long> {
    fun findByDepartmentId(departmentId: Long): List<Doctor>
    fun findBySpecializationId(specializationId: Long): List<Doctor>
}