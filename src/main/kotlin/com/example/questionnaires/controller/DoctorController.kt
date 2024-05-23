package com.example.questionnaires.controller

import com.example.questionnaires.entity.ApiResponse
import com.example.questionnaires.model.Department
import com.example.questionnaires.model.Doctor
import com.example.questionnaires.model.Specialization
import com.example.questionnaires.service.DoctorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/doctors")
class DoctorController(private val doctorService: DoctorService) {

    @GetMapping("/all")
    fun getAllDoctors(): ResponseEntity<ApiResponse<List<Doctor>>> {
        val doctors = doctorService.getAllDoctors()
        return ResponseEntity.ok(ApiResponse("Doctors fetched successfully", doctors, 200))
    }

    @GetMapping("/{id}")
    fun getDoctorById(@PathVariable id: Long): ResponseEntity<ApiResponse<Doctor>> {
        val doctor = doctorService.getDoctorById(id) ?: return ResponseEntity(
            ApiResponse("Doctor not found", null, 404), HttpStatus.NOT_FOUND
        )
        return ResponseEntity.ok(ApiResponse("Doctor fetched successfully", doctor, 200))
    }

    @PostMapping("/{id}/rate")
    fun rateDoctor(
        @PathVariable id: Long,
        @RequestParam teaching: Double,
        @RequestParam mentorship: Double,
        @RequestParam communication: Double,
        @RequestParam rate1: Double,
        @RequestParam rate2: Double,
        @RequestParam rate3: Double
    ): ResponseEntity<ApiResponse<Unit>> {
        doctorService.saveRating(id, teaching, mentorship, communication, rate1, rate2, rate3)
        return ResponseEntity.ok(ApiResponse("Rating saved successfully", null, 200))
    }

    @GetMapping("/department/{departmentId}")
    fun getDoctorsByDepartment(@PathVariable departmentId: Long): ResponseEntity<ApiResponse<List<Doctor>>> {
        val doctors = doctorService.getDoctorsByDepartment(departmentId)
        return ResponseEntity.ok(ApiResponse("Doctors fetched successfully", doctors, 200))
    }

    @GetMapping("/specialization/{specializationId}")
    fun getDoctorsBySpecialization(@PathVariable specializationId: Long): ResponseEntity<ApiResponse<List<Doctor>>> {
        val doctors = doctorService.getDoctorsBySpecialization(specializationId)
        return ResponseEntity.ok(ApiResponse("Doctors fetched successfully", doctors, 200))
    }

    @GetMapping("/departments")
    fun getAllDepartments(): ResponseEntity<ApiResponse<List<Department>>> {
        val departments = doctorService.getAllDepartments()
        return ResponseEntity.ok(ApiResponse("Departments fetched successfully", departments, 200))
    }

    @GetMapping("/specializations")
    fun getAllSpecializations(): ResponseEntity<ApiResponse<List<Specialization>>> {
        val specializations = doctorService.getAllSpecializations()
        return ResponseEntity.ok(ApiResponse("Specializations fetched successfully", specializations, 200))
    }

}