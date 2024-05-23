package com.example.questionnaires

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication


@AutoConfiguration
@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class QuestionnairesApplication

fun main(args: Array<String>) {
	runApplication<QuestionnairesApplication>(*args)
}