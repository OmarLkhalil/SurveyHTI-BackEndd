package com.example.questionnaires.model

import jakarta.persistence.*


@Entity
data class Department(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,
    var description: String,

    @ElementCollection
    @CollectionTable(name = "department_doctor_ids", joinColumns = [JoinColumn(name = "department_id")])
    @Column(name = "doctor_id")
    var doctorIds: List<Long> = listOf()
)

@Entity
data class Specialization(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,
    var description: String,

    @ElementCollection
    @CollectionTable(name = "specialization_doctor_ids", joinColumns = [JoinColumn(name = "specialization_id")])
    @Column(name = "doctor_id")
    var doctorIds: List<Long> = listOf()
)

@Entity
data class Doctor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,
    var description: String,
    var picture: String,
    var overallRating: Float = 0.0f,
    var teaching: Float = 0.0f,
    var mentorship: Float = 0.0f,
    var communication: Float = 0.0f,
    var rate1: Float = 0.0f,
    var rate2: Float = 0.0f,
    var rate3: Float = 0.0f,

    @ManyToOne @JoinColumn(name = "department_id")
    var department: Department? = null,

    @ManyToOne @JoinColumn(name = "specialization_id")
    var specialization: Specialization? = null
)