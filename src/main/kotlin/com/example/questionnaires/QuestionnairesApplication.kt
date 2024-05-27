package com.example.questionnaires

import org.h2.tools.Server
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import java.sql.SQLException


@SpringBootApplication
@Import(H2ServerConfiguration::class)
class QuestionnairesApplication {

//    @Bean
//    fun init(
//        doctorRepository: DoctorRepository,
//        departmentRepository: DepartmentRepository,
//        specializationRepository: SpecializationRepository,
//    ) = CommandLineRunner {
//        val departments = listOf(
//            Department(
//                name = "Physics",
//                description = "Department of Physics",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Department(
//                name = "Biology", description = "Department of Biology",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Department(
//                name = "Chemistry", description = "Department of Chemistry",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Department(
//                name = "Engineering",
//                description = "Department of Engineering",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Department(
//                name = "Medicine", description = "Department of Medicine",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            )
//        )
//
//        val savedDepartments = departmentRepository.saveAll(departments)
//        val specializations = listOf(
//            Specialization(
//                name = "Theoretical Physics",
//                description = "Specialization in Theoretical Physics",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Genetics",
//                description = "Specialization in Genetics",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Organic Chemistry",
//                description = "Specialization in Organic Chemistry",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Mechanical Engineering",
//                description = "Specialization in Mechanical Engineering",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Neurology",
//                description = "Specialization in Neurology",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Pathology",
//                description = "Specialization in Pathology",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Biotechnology",
//                description = "Specialization in Biotechnology",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Civil Engineering",
//                description = "Specialization in Civil Engineering",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Ophthalmology",
//                description = "Specialization in Ophthalmology",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            ),
//            Specialization(
//                name = "Pharmacology",
//                description = "Specialization in Pharmacology",
//                rate1 = 3,
//                rate2 = 4,
//                rate3 = 5
//            )
//        )
//        val savedSpecializations = specializationRepository.saveAll(specializations)
//
//        val doctors = listOf(
//            Doctor(
//                name = "Dr. Adam Johnson",
//                description = "Expert in theoretical physics",
//                picture = "https://randomuser.me/api/portraits/men/22.jpg",
//                department = savedDepartments[0],
//                specialization = savedSpecializations[0]
//            ),
//            Doctor(
//                name = "Dr. Sarah Williams",
//                description = "Expert in genetics",
//                picture = "https://randomuser.me/api/portraits/women/15.jpg",
//                department = savedDepartments[1],
//                specialization = savedSpecializations[1]
//            ),
//            Doctor(
//                name = "Dr. Michael Smith",
//                description = "Expert in organic chemistry",
//                picture = "https://randomuser.me/api/portraits/men/25.jpg",
//                department = savedDepartments[2],
//                specialization = savedSpecializations[2]
//            ),
//            Doctor(
//                name = "Dr. Emily Brown",
//                description = "Expert in mechanical engineering",
//                picture = "https://randomuser.me/api/portraits/women/24.jpg",
//                department = savedDepartments[3],
//                specialization = savedSpecializations[3]
//            ),
//            Doctor(
//                name = "Dr. Daniel Jones",
//                description = "Expert in neurology",
//                picture = "https://randomuser.me/api/portraits/men/27.jpg",
//                department = savedDepartments[4],
//                specialization = savedSpecializations[4]
//            ),
//            Doctor(
//                name = "Dr. Emma Davis",
//                description = "Expert in pathology",
//                picture = "https://randomuser.me/api/portraits/women/11.jpg",
//                department = savedDepartments[0],
//                specialization = savedSpecializations[5]
//            ),
//            Doctor(
//                name = "Dr. Matthew Wilson",
//                description = "Expert in biotechnology",
//                picture = "https://randomuser.me/api/portraits/men/30.jpg",
//                department = savedDepartments[1],
//                specialization = savedSpecializations[6]
//            ),
//            Doctor(
//                name = "Dr. Olivia Taylor",
//                description = "Expert in civil engineering",
//                picture = "https://randomuser.me/api/portraits/women/17.jpg",
//                department = savedDepartments[2],
//                specialization = savedSpecializations[7]
//            ),
//            Doctor(
//                name = "Dr. Noah Anderson",
//                description = "Expert in ophthalmology",
//                picture = "https://randomuser.me/api/portraits/men/35.jpg",
//                department = savedDepartments[3],
//                specialization = savedSpecializations[8]
//            ),
//            Doctor(
//                name = "Dr. Sophia Martin",
//                description = "Expert in pharmacology",
//                picture = "https://randomuser.me/api/portraits/women/19.jpg",
//                department = savedDepartments[4],
//                specialization = savedSpecializations[9]
//            ),
//            Doctor(
//                name = "Dr. Ethan White",
//                description = "Expert in medicine",
//                picture = "https://randomuser.me/api/portraits/men/41.jpg",
//                department = savedDepartments[0],
//                specialization = savedSpecializations[4]
//            ),
//            Doctor(
//                name = "Dr. Isabella Harris",
//                description = "Expert in physics",
//                picture = "https://randomuser.me/api/portraits/women/21.jpg",
//                department = savedDepartments[1],
//                specialization = savedSpecializations[0]
//            ),
//            Doctor(
//                name = "Dr. Jacob Thompson",
//                description = "Expert in biology",
//                picture = "https://randomuser.me/api/portraits/men/43.jpg",
//                department = savedDepartments[2],
//                specialization = savedSpecializations[1]
//            ),
//            Doctor(
//                name = "Dr. Mia Martinez",
//                description = "Expert in chemistry",
//                picture = "https://randomuser.me/api/portraits/women/23.jpg",
//                department = savedDepartments[3],
//                specialization = savedSpecializations[2]
//            ),
//            Doctor(
//                name = "Dr. William Robinson",
//                description = "Expert in engineering",
//                picture = "https://randomuser.me/api/portraits/men/45.jpg",
//                department = savedDepartments[4],
//                specialization = savedSpecializations[3]
//            )
//        )
//
//        doctorRepository.saveAll(doctors)
//
//        savedDepartments.forEach { department ->
//            val doctorIds = doctors.filter { it.department?.id == department.id }.map { it.id }
//            department.doctorIds = doctorIds
//            departmentRepository.save(department)
//        }
//
//        savedSpecializations.forEach { specialization ->
//            val doctorIds = doctors.filter { it.specialization?.id == specialization.id }.map { it.id }
//            specialization.doctorIds = doctorIds
//            specializationRepository.save(specialization)
//        }
//        logger.info("Database initialized with sample data.")
//    }

    companion object {
        private val logger = LoggerFactory.getLogger(QuestionnairesApplication::class.java)
    }
}

fun main(args: Array<String>) {
    val port = System.getenv("PORT") ?: "8080"
    System.getProperties().setProperty("server.port", port)
    runApplication<QuestionnairesApplication>(*args)
}

@Configuration
class H2ServerConfiguration {
    @Bean(initMethod = "start", destroyMethod = "stop")
    @Throws(SQLException::class)
    fun h2Server(): Server {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9080")
    }
}

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests()
            .anyRequest().permitAll()
            .and()
            .csrf().disable()
        return http.build()
    }
}