package com.example.questionnaires.repo

import com.example.questionnaires.model.Department
import org.springframework.data.jpa.repository.JpaRepository


interface DepartmentRepository : JpaRepository<Department, Long>
