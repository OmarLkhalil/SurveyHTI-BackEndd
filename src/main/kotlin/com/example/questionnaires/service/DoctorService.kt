package com.example.questionnaires.service

import com.example.questionnaires.model.Department
import com.example.questionnaires.model.Doctor
import com.example.questionnaires.model.Specialization
import com.example.questionnaires.repo.DepartmentRepository
import com.example.questionnaires.repo.DoctorRepository
import com.example.questionnaires.repo.SpecializationRepository
import org.springframework.stereotype.Service

@Service
class DoctorService(
    private val doctorRepository: DoctorRepository,
    private val departmentRepository: DepartmentRepository,
    private val specializationRepository: SpecializationRepository
) {

    fun getAllDoctors(): List<Doctor> = doctorRepository.findAll()

    fun getDoctorById(id: Long): Doctor? = doctorRepository.findById(id).orElse(null)

    fun getDoctorsByDepartment(departmentId: Long): List<Doctor> {
        return doctorRepository.findByDepartmentId(departmentId)
    }

    fun getDoctorsBySpecialization(specializationId: Long): List<Doctor> {
        return doctorRepository.findBySpecializationId(specializationId)
    }


    fun saveRating(
        id: Long,
        teaching: Double,
        mentorship: Double,
        communication: Double,
        rate1: Double,
        rate2: Double,
        rate3: Double
    ) {
        val doctor = doctorRepository.findById(id).orElseThrow { RuntimeException("Doctor not found") }
        doctor.teaching = teaching.toFloat()
        doctor.mentorship = mentorship.toFloat()
        doctor.communication = communication.toFloat()
        doctor.rate1 = rate1.toFloat()
        doctor.rate2 = rate2.toFloat()
        doctor.rate3 = rate3.toFloat()
        doctor.overallRating = (teaching + mentorship + communication + rate1 + rate2 + rate3).toFloat() / 6
        doctorRepository.save(doctor)
    }

    fun getAllDepartments(): List<Department> {
        return departmentRepository.findAll()
    }

    fun getAllSpecializations(): List<Specialization> {
        return specializationRepository.findAll()
    }
}