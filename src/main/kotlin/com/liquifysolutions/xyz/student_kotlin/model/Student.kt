package com.liquifysolutions.xyz.student_kotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "student")
data class Student(
    @Id val id: String? = null,
    val name: String,
    val age: Int,
    val assignedClass: String
)

data class ListStudentsInput(
    val nameSearch: String? = null,
    val age: Int? = null,
    val assignedClass: String? = null,
)