package com.example.questionnaires.repo

import com.example.questionnaires.model.Specialization
import org.springframework.data.jpa.repository.JpaRepository


interface SpecializationRepository : JpaRepository<Specialization, Long>
