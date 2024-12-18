package com.liquifysolutions.xyz.student_kotlin.repository

import com.liquifysolutions.xyz.student_kotlin.model.Student
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : MongoRepository<Student, String> {
    fun findStudentsByName(name: String): List<Student>
    fun findStudentsByAge(age: Int): List<Student>
}