package com.example.questionnaires.model

import jakarta.persistence.*


@Entity
data class Department(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,
    var description: String,
    var rate1: String,
    var rate2: String,
    var rate3: String,

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
    var rate1: String,
    var rate2: String,
    var rate3: String,

    @ElementCollection
    @CollectionTable(name = "specialization_doctor_ids", joinColumns = [JoinColumn(name = "specialization_id")])
    @Column(name = "doctor_id")
    var doctorIds: List<Long> = listOf()
)

@Entity
data class Subject(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String,
    var description: String,
    var rate1: String,
    var rate2: String,
    var rate3: String
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
    var rate1: String = "5",
    var rate2: String = "5",
    var rate3: String = "5",

    @ManyToOne @JoinColumn(name = "department_id")
    var department: Department? = null,

    @ManyToOne @JoinColumn(name = "specialization_id")
    var specialization: Specialization? = null
)
