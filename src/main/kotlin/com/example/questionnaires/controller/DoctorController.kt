package com.example.questionnaires.controller

import com.example.questionnaires.entity.ApiResponse
import com.example.questionnaires.entity.DepartmentDetailsResponse
import com.example.questionnaires.model.Department
import com.example.questionnaires.model.Doctor
import com.example.questionnaires.model.Specialization
import com.example.questionnaires.model.Subject
import com.example.questionnaires.service.DoctorService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@RestController
@RequestMapping("/api")
class DoctorController(private val doctorService: DoctorService) {

    @GetMapping("/doctors/all")
    fun getAllDoctors(): ResponseEntity<ApiResponse<List<Doctor>>> {
        val doctors = doctorService.getAllDoctors()
        return ResponseEntity.ok(ApiResponse("Doctors fetched successfully", doctors, 200))
    }

    @GetMapping("/doctors/details/{id}")
    fun getDoctorById(@PathVariable id: Long): ResponseEntity<ApiResponse<Doctor>> {
        val doctor = doctorService.getDoctorById(id) ?: return ResponseEntity(
            ApiResponse("Doctor not found", null, 404), HttpStatus.NOT_FOUND
        )
        return ResponseEntity.ok(ApiResponse("Doctor fetched successfully", doctor, 200))
    }


    @GetMapping("/departments/details/{departmentId}")
    fun getDoctorsByDepartment(@PathVariable departmentId: Long): ResponseEntity<ApiResponse<DepartmentDetailsResponse>> {
        val departmentDetails = doctorService.getDoctorsByDepartment(departmentId)
        return ResponseEntity.ok(ApiResponse("Department details fetched successfully", departmentDetails, 200))
    }

    @GetMapping("/specialization/details/{specializationId}")
    fun getDoctorsBySpecialization(@PathVariable specializationId: Long): ResponseEntity<ApiResponse<List<Doctor>>> {
        val doctors = doctorService.getDoctorsBySpecialization(specializationId)
        return ResponseEntity.ok(ApiResponse("Doctors fetched successfully", doctors, 200))
    }

    @GetMapping("/departments/all")
    fun getAllDepartments(): ResponseEntity<ApiResponse<List<Department>>> {
        val departments = doctorService.getAllDepartments()
        return ResponseEntity.ok(ApiResponse("Departments fetched successfully", departments, 200))
    }

    @GetMapping("/specializations/all")
    fun getAllSpecializations(): ResponseEntity<ApiResponse<List<Specialization>>> {
        val specializations = doctorService.getAllSpecializations()
        return ResponseEntity.ok(ApiResponse("Specializations fetched successfully", specializations, 200))
    }


    @GetMapping("/subjects/all")
    fun getAllSubjects(): ResponseEntity<ApiResponse<List<Subject>>> {
        val subjects = doctorService.getAllSubjects()
        return ResponseEntity.ok(ApiResponse("Subjects fetched successfully", subjects, 200))
    }



}


@Configuration
class WebConfig : WebMvcConfigurer {

    @Bean
    fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**")
                    .allowedOrigins("http://localhost:4200", "https://hare-helpful-bream.ngrok-free.app")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true)
            }
        }
    }
}