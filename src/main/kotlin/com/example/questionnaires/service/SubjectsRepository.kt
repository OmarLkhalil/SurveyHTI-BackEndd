package com.example.questionnaires.service

import com.example.questionnaires.model.Subject
import org.springframework.data.jpa.repository.JpaRepository


interface SubjectsRepository  : JpaRepository<Subject, Long>