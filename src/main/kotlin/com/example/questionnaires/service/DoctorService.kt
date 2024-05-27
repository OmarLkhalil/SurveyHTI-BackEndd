package com.example.questionnaires.service

import com.example.questionnaires.entity.DepartmentDetailsResponse
import com.example.questionnaires.model.Department
import com.example.questionnaires.model.Doctor
import com.example.questionnaires.model.Specialization
import com.example.questionnaires.model.Subject
import com.example.questionnaires.repo.DepartmentRepository
import com.example.questionnaires.repo.DoctorRepository
import com.example.questionnaires.repo.SpecializationRepository
import jakarta.persistence.EntityNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service



@Service
class DoctorService(
    private val doctorRepository: DoctorRepository,
    private val departmentRepository: DepartmentRepository,
    private val specializationRepository: SpecializationRepository,
    private val subjectsRepository: SubjectsRepository
) {

    fun getAllDoctors(): List<Doctor> {
        val doctors = doctorRepository.findAll()
        return doctors
    }

    fun getAllSubjects() : List<Subject> {
        return subjectsRepository.findAll()
    }


    fun getDoctorById(id: Long): Doctor? = doctorRepository.findById(id).orElse(null)

    fun getDoctorsByDepartment(departmentId: Long): DepartmentDetailsResponse {
        val department = departmentRepository.findById(departmentId)
            .orElseThrow { EntityNotFoundException("Department not found") }

        val doctors = doctorRepository.findByDepartmentId(departmentId)

        return DepartmentDetailsResponse(
            id = department.id,
            name = department.name,
            rate1 = 2,
            rate2 = 3,
            rate3 = 3,
            description = department.description,
            doctors = doctors
        )
    }
    fun getDoctorsBySpecialization(specializationId: Long): List<Doctor> {
        return doctorRepository.findBySpecializationId(specializationId)
    }


    fun getAllDepartments(): List<Department> {
        return departmentRepository.findAll()
    }

    fun getAllSpecializations(): List<Specialization> {
        return specializationRepository.findAll()
    }
}